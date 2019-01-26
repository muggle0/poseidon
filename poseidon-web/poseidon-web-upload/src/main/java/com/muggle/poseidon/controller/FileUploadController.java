package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-01-26 15:47
 **/
@RestController("/upload")
public class FileUploadController {
    @Value("${upload.file}")
    String path;

    @PostMapping("/files")
    public ResultBean fileUpload(@RequestParam("files") MultipartFile[] files) {

        StringBuilder builder = new StringBuilder();
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
            File fileDir = new File(path);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }

            String path = fileDir.getAbsolutePath();
            try {
                file.transferTo(new File(fileDir.getAbsolutePath(), fileName));
            } catch (IOException e) {
                continue;
            }
            builder.append(file.getOriginalFilename()).append(",");
        }
    }

}
