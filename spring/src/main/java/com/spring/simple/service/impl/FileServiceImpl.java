package com.spring.simple.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.spring.simple.dao.FileDao;
import com.spring.simple.model.DiffFile;
import com.spring.simple.model.DiffFileExample;
import com.spring.simple.service.FileService;
import com.spring.simple.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 文件相关服务
 * Created by fengxu on 15-12-15.
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    FileDao fileDao;

    @Override
    public String compareFile(File sourceFile, File targetFile) throws IOException {
        Map<String, String> sourceFileMap = FileUtil.propertiesToMap(sourceFile);
        Map<String, String> targetFileMap = FileUtil.propertiesToMap(targetFile);

        MapDifference<String, String> difference = Maps.difference(sourceFileMap, targetFileMap);
        Map<String, String> onlyOnSourceFile = difference.entriesOnlyOnLeft();
        Map<String, String> onlyOnTargetFile = difference.entriesOnlyOnRight();
        Map<String, MapDifference.ValueDifference<String>> valueDifference = difference.entriesDiffering();

        return compareMapResult(onlyOnSourceFile, onlyOnTargetFile, valueDifference);
    }

    @Override
    @Transactional
    public boolean addDiffFile(File sourceFile, File targetFile, String difference) throws IOException {
        Preconditions.checkNotNull(sourceFile, "参数错误");
        Preconditions.checkNotNull(targetFile, "参数错误");
        Preconditions.checkNotNull(difference, "参数错误");

        DiffFile diffFile = new DiffFile();
        diffFile.setDiffTime(new Date());
        diffFile.setSourceFile(FileUtil.fileToString(sourceFile));
        diffFile.setTargetFile(FileUtil.fileToString(targetFile));
        diffFile.setDifference(difference);
        diffFile.setSourceFileName(sourceFile.getName());
        diffFile.setTargetFileName(targetFile.getName());

        return fileDao.insert(diffFile) == 1;
    }

    @Override
    public List<DiffFile> diffFileList(Integer start, Integer pageSize) {
        Preconditions.checkArgument(start >= 0, "参数错误");
        Preconditions.checkArgument(pageSize >= 0, "参数错误");

        return fileDao.selectByPaging(start, pageSize);
    }

    @Override
    public int diffFileCount() {
        DiffFileExample diffFileExample = new DiffFileExample();
        return fileDao.countByExample(diffFileExample);
    }

    @Override
    @Transactional
    public boolean deleteDiffFileById(int id) {
        Preconditions.checkArgument(id > 0, "参数错误");

        return fileDao.deleteByPrimaryKey(id) == 1;
    }

    private String compareMapResult(Map<String, String> onlyOnSourceFile,
                                    Map<String, String> onlyOnTargetFile,
                                    Map<String, MapDifference.ValueDifference<String>> valueDifference) {
        StringBuilder stringBuilder = new StringBuilder();
        if (null != onlyOnSourceFile && onlyOnSourceFile.size() > 0) {
            for (Map.Entry keyValue : onlyOnSourceFile.entrySet()) {
                stringBuilder.append("-")
                        .append(keyValue.getKey())
                        .append("=")
                        .append(keyValue.getValue())
                        .append("\n");
            }
        }

        if (null != onlyOnTargetFile && onlyOnTargetFile.size() > 0) {
            for (Map.Entry keyValue : onlyOnTargetFile.entrySet()) {
                stringBuilder.append("+")
                        .append(keyValue.getKey())
                        .append("=")
                        .append(keyValue.getValue())
                        .append("\n");
            }
        }

        if (null != valueDifference && valueDifference.size() > 0) {
            for (String key : valueDifference.keySet()) {
                stringBuilder.append("-")
                        .append(key)
                        .append("=")
                        .append(valueDifference.get(key).leftValue())
                        .append(";")
                        .append("+")
                        .append(key)
                        .append("=")
                        .append(valueDifference.get(key).rightValue())
                        .append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
