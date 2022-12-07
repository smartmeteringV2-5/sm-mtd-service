package com.kspia.mtdservice.repository;

import com.kspia.mtdservice.entity.MtdWaterLeakExamGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface GroupRepository extends JpaRepository<MtdWaterLeakExamGroup, Long> {
    List<MtdWaterLeakExamGroup> findByExamPlanStartDtBetween(Date fromDate, Date toDate);
}

