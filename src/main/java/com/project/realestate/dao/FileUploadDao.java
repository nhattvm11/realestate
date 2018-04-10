package com.project.realestate.dao;
import java.util.List;
import com.project.realestate.model.UploadedFile;

public interface FileUploadDao {
    List<UploadedFile> listFiles();
    UploadedFile getFile(Long id);
    UploadedFile saveFile(UploadedFile uploadedFile);
}
