package com.prism.mr.repository;

import com.prism.mr.model.Attendance;
import com.prism.mr.model.AttendanceProjection;
import com.prism.mr.model.QAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "attendance", collectionResourceRel = "attendance", excerptProjection = AttendanceProjection.class)
public interface AttendanceRepository extends JpaRepository<Attendance, Long>, QuerydslPredicateExecutor<Attendance>, QuerydslBinderCustomizer<QAttendance> {
    @Override
    default void customize(QuerydslBindings bindings, QAttendance attendance) {
        bindings.bind(attendance.checkIn).all((path, value) -> {
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
