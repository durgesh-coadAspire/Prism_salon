package com.prism.mr.repository;

import com.prism.mr.model.LeaveType;
import com.prism.mr.model.LeaveTypeProjection;
import com.prism.mr.model.QLeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "leaveType", collectionResourceRel = "leaveType",excerptProjection = LeaveTypeProjection.class)
public interface LeaveTypeRepository extends JpaRepository<LeaveType,Long>, QuerydslPredicateExecutor<QLeaveType> {
}
