package com.prism.mr.repository;

import com.prism.mr.model.LookUp;
import com.prism.mr.model.LookUpProjection;
import com.prism.mr.model.QLookUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "lookUp", collectionResourceRel = "lookUp",excerptProjection= LookUpProjection.class)
public interface LookUpRepository extends JpaRepository<LookUp,Long>, QuerydslPredicateExecutor<QLookUp> {
}
