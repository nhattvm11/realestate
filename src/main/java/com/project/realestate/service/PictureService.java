package com.project.realestate.service;

import com.project.realestate.exception.ArticleException;

public interface PictureService {
    public void saveImage(String articleId, String path, boolean thumbnail) throws ArticleException;
    public void deletePicture(String id);
}
