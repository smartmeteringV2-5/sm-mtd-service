package com.example.orderservice.repository;

import com.example.orderservice.jpa.MtdWaterLeakExamGroupEntity;
import com.example.orderservice.vo.RequestGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface GroupRepository extends JpaRepository<MtdWaterLeakExamGroupEntity, Long> {
    List<MtdWaterLeakExamGroupEntity> findByExamPlanStartDtBetween(Date fromDate, Date toDate);
}

