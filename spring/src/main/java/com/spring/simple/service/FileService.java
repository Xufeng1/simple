package com.spring.simple.service;

import com.spring.simple.model.DiffFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 文件服务接口
 * Created by fengxu on 15-12-15.
 */
public interface FileService {

    /**
     * 比较两个文件的不同
     * @param sourceFile 源文件
     * @param targetFile 目标文件
     * @return 不同
     */
    String compareFile(File sourceFile, File targetFile) throws IOException;

    /**
     * 添加比较信息
     * @param sourceFile 源文件
     * @param targetFile 目标文件
     * @param difference 差异
     * @return 是否添加成功
     */
    boolean addDiffFile(File sourceFile, File targetFile, String difference) throws IOException;

    /**
     * 文件比较信息列表
     * @return list
     */
    List<DiffFile> diffFileList(Integer page, Integer pageSize);

    /**
     * 比较文件历史的数量
     * @return 数量
     */
    int diffFileCount();

    /**
     * 删除比较信息
     * @param id 信息ID
     * @return 是否删除
     */
    boolean deleteDiffFileById(int id);
}
