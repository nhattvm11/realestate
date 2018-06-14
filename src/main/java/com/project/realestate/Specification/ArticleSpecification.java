package com.project.realestate.Specification;

import com.project.realestate.entity.Article;
import com.project.realestate.model.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ArticleSpecification implements Specification<Article> {

    public ArticleSpecification(){

    }

    public ArticleSpecification(SearchCriteria searchCriteria){
        this.searchCriteria = searchCriteria;
    }

    private SearchCriteria searchCriteria;
//    public static Specification<Article> titleOrDescriptionContainsIgnoreCase(String searchTerm) {
//        return (root, query, cb) -> {
//            String containsLikePattern = getContainsLikePattern(searchTerm);
//            return cb.or(
//                    cb.like(cb.lower(root.get(Article_.title)), containsLikePattern),
//                    cb.like(cb.lower(root.get(Article_.description)), containsLikePattern)
//            );
//        };
//    }

    private static String getContainsLikePattern(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return "%";
        }
        else {
            return "%" + searchTerm.toLowerCase() + "%";
        }
    }

    @Nullable
    @Override
    public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (searchCriteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
        }
        else if (searchCriteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
        }
        else if (searchCriteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(
                        root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
            } else {
                return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
            }
        }
        return null;
    }
}
