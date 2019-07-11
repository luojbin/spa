package com.loyofo.spa.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/file")
public class FileController {
    private static Logger log = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String showUploadForm() {
        return "file";
    }
    @RequestMapping(value = "/uploadToByte", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestPart("file") byte[] file,
                             @RequestParam("msg") String message,
                             @RequestParam("uploader") String name) {
        log.info("获取到 {} 上传的文件数据, 文件大小为: {}, 备注信息:{}", name, file.length, message);
        return "上传成功";
    }

}
