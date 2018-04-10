package com.project.realestate.service;
import java.util.List;

import com.project.realestate.dao.FileUploadDao;
import com.project.realestate.model.UploadedFile;
import com.project.realestate.service.FileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class FileUploadServiceImpl implements FileUploadService  {
    @Autowired
    private FileUploadDao dao;

    @Transactional(readOnly = true)
    public List<UploadedFile> listFiles() {

        return dao.listFiles();
    }

    @Transactional(readOnly = true)
    public UploadedFile getFile(Long id) {

        return dao.getFile(id);
    }

    @Transactional
    public UploadedFile saveFile(UploadedFile uploadedFile) {

        return dao.saveFile(uploadedFile);
    }
}
