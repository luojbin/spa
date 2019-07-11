package com.loyofo.spa.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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
    public String uploadToByte(@RequestPart("file") byte[] file,
                             @RequestParam("msg") String message,
                             @RequestParam("uploader") String name) {
        log.info("获取到 {} 上传的文件数据, 文件大小为: {}, 备注信息:{}", name, file.length, message);
        return "上传成功";
    }

    @RequestMapping(value = "/uploadToMp", method = RequestMethod.POST)
    @ResponseBody
    public String uploadToMp(@RequestPart("file") MultipartFile file,
                             @RequestParam("msg") String message,
                             @RequestParam("uploader") String name) throws IOException {
        log.info("获取到 {} 上传的文件数据, 备注信息:{} \n原始文件名:{}, 文件类型:{}, 文件大小为: {}", name, message,
                file.getOriginalFilename(), file.getContentType(), file.getSize());

        String path = "d:/data/java/";
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdirs();
        }
        file.transferTo(new File(path + file.getOriginalFilename()));
        return "上传成功";
    }

}
