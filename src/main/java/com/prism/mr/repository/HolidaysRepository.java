package com.prism.mr.repository;

import com.prism.mr.model.Holidays;
import com.prism.mr.model.HolidaysProjection;
import com.prism.mr.model.QHolidays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "holidays",collectionResourceRel = "holidays",excerptProjection = HolidaysProjection.class)
public interface HolidaysRepository extends JpaRepository<Holidays,Long> , QuerydslPredicateExecutor<QHolidays> {
}
