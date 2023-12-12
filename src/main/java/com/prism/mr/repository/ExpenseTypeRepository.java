package com.prism.mr.repository;

import com.prism.mr.model.ExpenseProjection;
import com.prism.mr.model.ExpenseType;
import com.prism.mr.model.ExpenseTypeProjection;
import com.prism.mr.model.QExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "expenseType",collectionResourceRel= "expenseType",excerptProjection= ExpenseTypeProjection.class)
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType,Long>, QuerydslPredicateExecutor<QExpenseType> {

}
