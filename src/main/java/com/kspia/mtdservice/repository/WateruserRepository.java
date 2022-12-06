package com.kspia.mtdservice.repository;

import com.querydsl.core.Tuple;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface WateruserRepository  {
    List<Tuple> findByExamGroupIdx(Long exam_group_idx);
}
