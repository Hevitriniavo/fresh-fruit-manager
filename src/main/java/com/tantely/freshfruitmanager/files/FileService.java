package com.tantely.freshfruitmanager.files;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String saveFile(MultipartFile file);

    boolean deleteFile(String url);
}
