package com.prism.mr.repository;

import com.prism.mr.model.PurchaseOrder;
import com.prism.mr.model.PurchaseOrderProjection;
import com.prism.mr.model.QPurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "purchaseOrder",path = "purchaseOrder",excerptProjection = PurchaseOrderProjection.class)
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> ,QuerydslPredicateExecutor<QPurchaseOrder> {

}
