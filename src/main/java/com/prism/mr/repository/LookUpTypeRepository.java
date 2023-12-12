package com.prism.mr.repository;

import com.prism.mr.model.LookUpType;
import com.prism.mr.model.LookUpTypeProjection;
import com.prism.mr.model.QLookUpType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "lookUpType", collectionResourceRel = "lookUpType",excerptProjection= LookUpTypeProjection.class)
public interface LookUpTypeRepository extends JpaRepository<LookUpType,Long>, QuerydslPredicateExecutor<QLookUpType> {

}
