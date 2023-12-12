package com.prism.mr.repository;

import com.prism.mr.model.ProductDetails;
import com.prism.mr.model.ProductDetailsProjection;
import com.prism.mr.model.QProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "productDetails", collectionResourceRel = "productDetails", excerptProjection = ProductDetailsProjection.class)
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long>, QuerydslPredicateExecutor<QProductDetails> {
}
