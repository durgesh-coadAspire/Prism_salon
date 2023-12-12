package com.prism.mr.repository;

import com.prism.mr.model.Products;
import com.prism.mr.model.ProductsProjection;
import com.prism.mr.model.QProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "products", collectionResourceRel = "products", excerptProjection = ProductsProjection.class)
public interface ProductsRepository extends JpaRepository<Products, Long>, QuerydslPredicateExecutor<QProducts>, QuerydslBinderCustomizer<QProducts> {
    @Override
    default void customize(QuerydslBindings bindings, QProducts products) {
        //filter By OrderDate
        bindings.bind(products.orderDate).all((path, value) -> {
            List<? extends LocalDate> dates = new ArrayList<>(value);
            if (dates.size() == 1) {
                return Optional.of(path.eq(dates.get(0)));
            } else {
                LocalDate from = dates.get(0);
                LocalDate to = dates.get(1);
                return Optional.of(path.between(from, to));
            }
        });
        //filter By OrderId
        bindings.bind(products.orderId).all((path, value) -> {
            List<Long> orderIds = new ArrayList<>(value);
            if (orderIds.size() == 1) {
                return Optional.of(path.eq(orderIds.get(0)));
            } else {
                Long from = orderIds.get(0);
                Long to = orderIds.get(1);
                return Optional.of(path.between(from, to));
            }
        });
    }
}
