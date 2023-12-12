package com.prism.mr.repository;

import com.prism.mr.model.PrimarySales;
import com.prism.mr.model.PrimarySalesProjection;
import com.prism.mr.model.QPrimarySales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "primarySales", collectionResourceRel = "primarySales", excerptProjection = PrimarySalesProjection.class)
public interface PrimarySalesRepository extends JpaRepository<PrimarySales,Long>, QuerydslPredicateExecutor <QPrimarySales>{
}
