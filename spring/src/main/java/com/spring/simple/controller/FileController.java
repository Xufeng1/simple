package com.spring.simple.controller;

import com.google.common.collect.Lists;
import com.spring.simple.model.ApiResult;
import com.spring.simple.model.DiffFile;
import com.spring.simple.model.ErrorCodeEnum;
import com.spring.simple.model.api.PageParam;
import com.spring.simple.service.FileService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 文件控制层
 * Created by fengxu on 15-12-15.
 */
@Controller
@RequestMapping(value = "/file")
public class FileController {

    private static final Logger logger = getLogger(FileController.class);

    public static final String UPLOAD_PATH = "/WEB-INF/upload/";

    @Resource
    FileService fileService;

    @RequestMapping(value = "/diff", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult compareFile(@RequestParam("source") MultipartFile source,
                              @RequestParam("target") MultipartFile target,
                              HttpServletRequest request) throws IOException {
        MultipartFile[] files = new MultipartFile[]{source, target};
        List<File> uploadFiles = Lists.newArrayList();
        if (files.length > 0) {
            for (MultipartFile file : files) {
                String filename = file.getOriginalFilename();
                String path = request.getSession().getServletContext().getRealPath(UPLOAD_PATH + filename);
                File uploadFile = new File(path);
                try {
                    FileUtils.copyInputStreamToFile(file.getInputStream(), uploadFile);// 复制临时文件到指定目录下
                } catch (IOException e) {
                    logger.error("文件上传异常");
                    throw new IllegalArgumentException("文件上传异常");
                }
                uploadFiles.add(uploadFile);
            }
        }
        /*比较差异*/
        String difference = fileService.compareFile(uploadFiles.get(0), uploadFiles.get(1));

        ApiResult<String> result = new ApiResult();
        /*将差异信息存入*/
        if (fileService.addDiffFile(uploadFiles.get(0), uploadFiles.get(1), difference)) {
            return result.success(difference);
        }
        return result.fail(ErrorCodeEnum.INTERNAL_ERROR);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult diffFileList(@RequestBody PageParam pageParam) {

        ApiResult<List<DiffFile>> result = new ApiResult();

        int page = pageParam.getPage();
        int pageSize = pageParam.getPageSize();

        int count = fileService.diffFileCount();
        if (count > pageSize) {
            List<DiffFile> diffFiles = fileService.diffFileList(page, pageSize);
            return result.success("显示部分", diffFiles);
        } else {
            List<DiffFile> diffFiles = fileService.diffFileList(0, count);
            return result.success("全部显示", diffFiles);
        }
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ApiResult deleteDiffFile(@RequestParam int id) {

        ApiResult result = new ApiResult();

        if (fileService.deleteDiffFileById(id)) {
            logger.info("删除文件对比信息,id：{}", id);
            return result.success("删除成功", null);
        } else {
            logger.info("删除文件信息失败,id：{}", id);
            return result.fail(ErrorCodeEnum.INTERNAL_ERROR);
        }
    }
}
