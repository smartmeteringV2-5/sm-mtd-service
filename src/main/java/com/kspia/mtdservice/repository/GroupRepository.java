package com.kspia.mtdservice.repository;

import com.kspia.mtdservice.jpa.MtdWaterLeakExamGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface GroupRepository extends JpaRepository<MtdWaterLeakExamGroupEntity, Long> {
    List<MtdWaterLeakExamGroupEntity> findByExamPlanStartDtBetween(Date fromDate, Date toDate);
}

