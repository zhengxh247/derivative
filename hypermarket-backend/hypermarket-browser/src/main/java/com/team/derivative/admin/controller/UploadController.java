package com.team.derivative.admin.controller;

import com.team.derivative.admin.exceptioin.ResultBody;
import com.team.derivative.admin.service.FileMangerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhengxh
 */
@RestController
@RequestMapping("/file")
@Api(tags = {"文件上传管理"}, description = "file")
public class UploadController {

    @Autowired
    private FileMangerService service;

    @PostMapping("/multiUpload")
    @ResponseBody
    public ResultBody multiUpload(@RequestParam("upFile") MultipartFile[] files , @RequestParam("filePath") String filePath) {

        return ResultBody.success(service.multiUploadFile(files,filePath));
    }
}
