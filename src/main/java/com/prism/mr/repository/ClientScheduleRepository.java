package com.prism.mr.repository;

import com.prism.mr.model.ClientSchedule;
import com.prism.mr.model.ClientScheduleProjection;
import com.prism.mr.model.QClientSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "schedules", collectionResourceRel = "schedules",excerptProjection= ClientScheduleProjection.class)
public interface ClientScheduleRepository extends JpaRepository<ClientSchedule,Long>, QuerydslPredicateExecutor<QClientSchedule>, QuerydslBinderCustomizer<QClientSchedule> {
    @Override
    default void customize(QuerydslBindings bindings, QClientSchedule clientSchedule) {
        bindings.bind(clientSchedule.startAt).all((path, value) -> {
            List<? extends LocalDateTime> dates = new ArrayList<>(value);
            if (dates.size() == 1) {
                return Optional.of(path.eq(dates.get(0)));
            } else {
                LocalDateTime from = dates.get(0);
                LocalDateTime to = dates.get(1);
                return Optional.of(path.between(from, to));
            }
        });
        bindings.bind(clientSchedule.endAt).all((path, value) -> {
            List<? extends LocalDateTime> dates = new ArrayList<>(value);
            if (dates.size() == 1) {
                return Optional.of(path.eq(dates.get(0)));
            } else {
                LocalDateTime from = dates.get(0);
                LocalDateTime to = dates.get(1);
                return Optional.of(path.between(from, to));
            }
        });
    }
}
