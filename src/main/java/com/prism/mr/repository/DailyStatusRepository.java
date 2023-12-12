package com.prism.mr.repository;

import com.prism.mr.model.DailyStatus;
import com.prism.mr.model.DailyStatusProjection;
import com.prism.mr.model.DepartmentsProjection;
import com.prism.mr.model.QDailyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "daily_status", collectionResourceRel = "daily_status",excerptProjection= DailyStatusProjection.class)
public interface DailyStatusRepository extends JpaRepository<DailyStatus,Long>, QuerydslPredicateExecutor<QDailyStatus> {
}
