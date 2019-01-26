package com.muggle.poseidon.manager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-01-26 17:28
 **/
@Service
public class UploadManager {
    @Value("${upload.file}")
    String path;
    public void saveFiles(MultipartFile[] files){
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
        }
    }
}
