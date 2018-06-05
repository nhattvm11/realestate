package com.project.realestate.Specification;

import com.project.realestate.entity.Article;
import com.project.realestate.model.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ArticleSpecificationBuilder {
    private final List<SearchCriteria> params;

    public ArticleSpecificationBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public ArticleSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Article> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<Article>> specs = new ArrayList<>();
        for (SearchCriteria param : params) {
            specs.add(new ArticleSpecification(param));
        }

        Specification<Article> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}
