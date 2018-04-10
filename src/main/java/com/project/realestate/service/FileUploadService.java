package com.project.realestate.service;
import com.project.realestate.model.UploadedFile;
import java.util.List;

public interface FileUploadService {
    List<UploadedFile> listFiles();
    UploadedFile getFile(Long id);
    UploadedFile saveFile(UploadedFile uploadedFile);
}
