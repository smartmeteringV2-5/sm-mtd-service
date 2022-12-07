package com.kspia.mtdservice.repository;

import com.kspia.mtdservice.jpa.QConsumerModemInfoEntity;
import com.kspia.mtdservice.jpa.QMtdWaterLeakExamWateruserEntity;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class WateruserRepositoryImpl implements WateruserRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public WateruserRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

//    public List<ConsumerModemInfoEntity> findByExamGroupIdx(Long exam_group_idx) {
//
//        QConsumerModemInfoEntity consumerModemInfoEntity =QConsumerModemInfoEntity.consumerModemInfoEntity;
//
//        return  jpaQueryFactory.selectFrom(consumerModemInfoEntity).fetch();
//
//    }

    @Override
    public List<Tuple> findByExamGroupIdx(Long exam_group_idx) {

        QMtdWaterLeakExamWateruserEntity wateruserEntity = QMtdWaterLeakExamWateruserEntity.mtdWaterLeakExamWateruserEntity;
        QConsumerModemInfoEntity consumerModemInfoEntity = QConsumerModemInfoEntity.consumerModemInfoEntity;

        return jpaQueryFactory.select(consumerModemInfoEntity, wateruserEntity)
            .from(consumerModemInfoEntity)
            .join(wateruserEntity).on(consumerModemInfoEntity.consumer_sid.eq(wateruserEntity.consumer_sid.longValue()))
            .fetch();

    }
}
