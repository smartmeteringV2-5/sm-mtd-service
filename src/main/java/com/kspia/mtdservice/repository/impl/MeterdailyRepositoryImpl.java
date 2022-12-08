package com.kspia.mtdservice.repository.impl;

import com.kspia.mtdservice.dto.MeterdailyDto;
import com.kspia.mtdservice.dto.MeterdailyDto.MeterCount;
import com.kspia.mtdservice.dto.MeterdailyDto.ModemCount;
import com.kspia.mtdservice.entity.QMeterdaily;
import com.kspia.mtdservice.entity.QMtdWaterLeakExamWateruser;
import com.kspia.mtdservice.repository.MeterdailyRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @since 2022-12-08
 * @author kkny3
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : MeterdailyRepositoryImpl 클래스
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-08 kkny3 : 최초 작성
 * 2022-12-08 kkny3 : countByModemStatus 작업
 */
@Repository
public class MeterdailyRepositoryImpl implements MeterdailyRepository {

    private final JPAQueryFactory jpaQueryFactory;
    QMeterdaily meterdaily = QMeterdaily.meterdaily;

    public MeterdailyRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public ModemCount countByModemStatus() {
        return jpaQueryFactory.select(Projections.bean(
                    MeterdailyDto.ModemCount.class,
                    new CaseBuilder().when(meterdaily.modem_battery.in(0, 1)).then(1L).otherwise(0L).sum().as("modemLowBatteryCnt"),
                    new CaseBuilder().when(meterdaily.time_sync.eq(0)).then(1L).otherwise(0L).sum().as("timeSyncCnt"),
                    meterdaily.modem_connect.sum().longValue().as("disconnectCnt")
                )
            )
            .from(meterdaily)
            .fetchOne();
    }
    
    @Override
    public MeterCount countByMeterStatus() {
        return jpaQueryFactory.select(Projections.bean(
                    MeterdailyDto.MeterCount.class,
                    new CaseBuilder().when(meterdaily.meter_battery.in(0, 4)).then(1L).otherwise(0L).sum().as("meterLowBatteryCnt"),
                    new CaseBuilder().when(meterdaily.meter_waterleak.in(0, 1)).then(1L).otherwise(0L).sum().as("waterLeakCnt"),
                    new CaseBuilder().when(meterdaily.meter_overflow.eq(0)).then(1L).otherwise(0L).sum().as("overflowCnt")
                )
            )
            .from(meterdaily)
            .fetchOne();
    }
}
