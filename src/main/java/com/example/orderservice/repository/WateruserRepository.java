package com.example.orderservice.repository;

import com.example.orderservice.jpa.MtdWaterLeakExamWateruserEntity;
import com.example.orderservice.jpa.QMtdWaterLeakExamWateruserEntity;
import com.querydsl.core.QueryFactory;
import io.vavr.Value;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WateruserRepository extends  JpaRepository<MtdWaterLeakExamWateruserEntity,Long> {
    @Query(nativeQuery = true,
            value = "SELECT v.mng_id, v.wateruser_type, v.wateruser_name, v.new_address, " +
                    "v.wateruser_indust, v.area_nm, v.wateruser_state, w.exam_result, w.leak_min_usage, w.area_id, w.dividarea," +
                    " w.dongno, w.group_sid, w.consumer_sid, w.exam_group_idx, w.exam_wateruser_idx, w.city " +
                    "FROM consumer_modem_info As v JOIN mtd_water_leak_exam_wateruser " +
                    "As w ON w.consumer_sid = v.consumer_sid WHERE exam_group_idx = ?")
    List<MtdWaterLeakExamWateruserEntity> findByExamGroupIdx(Long examGroupIdx);
}






