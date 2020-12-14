package com.team.derivative.admin.service;

import com.team.derivative.admin.exceptioin.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author zhengxh
 */
@Service
public class FileMangerService {

    /**
     * 多批文件上传
     * @param files
     * @param filePath
     * @return
     */
    public Boolean multiUploadFile(MultipartFile[] files ,String filePath){
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (file.isEmpty()) {
                return false;
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                throw ServiceException.fileUploadError(dest.getName());
            }
        }
        return true;
    }
}
