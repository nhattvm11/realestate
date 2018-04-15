package com.project.realestate.service;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.Picture;
import com.project.realestate.exception.ArticleException;
import com.project.realestate.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    ArticleService articleService;

    @Autowired
    PictureRepository pictureRepository;

    @Override
    public void saveImage(String articleId, String path, boolean thumbnail) throws ArticleException {
        Picture picture = new Picture();
        picture.setId(UUID.randomUUID().toString());
        Article article = articleService.findById(articleId);
        picture.setArticleByArticleId(article);
        picture.setThumbnail(thumbnail);
        picture.setUrl(path);
        pictureRepository.save(picture);
    }
}
