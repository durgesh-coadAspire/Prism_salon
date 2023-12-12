package com.prism.mr.repository;

import com.prism.mr.model.MemberProjection;
import com.prism.mr.model.MemberSalary;
import com.prism.mr.model.MemberSalaryProjection;
import com.prism.mr.model.QMemberSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "member_salary", collectionResourceRel = "member_salary",excerptProjection= MemberSalaryProjection.class)
public interface MemberSalaryRepository extends JpaRepository<MemberSalary,Long> , QuerydslPredicateExecutor<QMemberSalary> {
}
