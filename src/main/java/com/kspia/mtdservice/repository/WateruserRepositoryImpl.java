package com.kspia.mtdservice.repository;

import com.kspia.mtdservice.entity.QConsumerModemInfo;
import com.kspia.mtdservice.entity.QMtdWaterLeakExamWateruser;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

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

        QMtdWaterLeakExamWateruser wateruser = QMtdWaterLeakExamWateruser.mtdWaterLeakExamWateruser;
        QConsumerModemInfo consumerModemInfo = QConsumerModemInfo.consumerModemInfo;

        return jpaQueryFactory.select(consumerModemInfo, wateruser)
            .from(consumerModemInfo)
            .join(wateruser).on(consumerModemInfo.consumer_sid.eq(wateruser.consumer_sid.longValue()))
            .fetch();

    }
}
