package com.project.realestate.Specification;

import com.project.realestate.entity.Article;
import com.project.realestate.entity.Article_;
import org.springframework.data.jpa.domain.Specification;

public class ArticleSpecification {
    public static Specification<Article> titleOrDescriptionContainsIgnoreCase(String searchTerm) {
        return (root, query, cb) -> {
            String containsLikePattern = getContainsLikePattern(searchTerm);
            return cb.or(
                    cb.like(cb.lower(root.get(Article_.title)), containsLikePattern),
                    cb.like(cb.lower(root.get(Article_.description)), containsLikePattern)
            );
        };
    }

    private static String getContainsLikePattern(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return "%";
        }
        else {
            return "%" + searchTerm.toLowerCase() + "%";
        }
    }
}
