package com.kspia.mtdservice.repository.impl;

import com.kspia.mtdservice.entity.QConsumerModemInfo;
import com.kspia.mtdservice.entity.QMeterdaily;
import com.kspia.mtdservice.repository.MeterdailyRepository;
import com.kspia.mtdservice.vo.RequestEquipState;
import com.kspia.mtdservice.vo.RequestReceivingState;
import com.kspia.mtdservice.vo.ResponseDashboardMap;
import com.kspia.mtdservice.vo.ResponseModemCount;
import com.kspia.mtdservice.vo.ResponseReceivingStateCount;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
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
 * 2022-12-09 kkny3 : findMapListByEquipState 작업
 * 2022-12-13 kkny3 : countByReceivingState 작업
 * 2022-12-14 kkny3 : findMapListByReceivingState 작업
 */
@Repository
public class MeterdailyRepositoryImpl implements MeterdailyRepository {

    private final JPAQueryFactory jpaQueryFactory;
    QMeterdaily meterdaily = QMeterdaily.meterdaily;
    QConsumerModemInfo consumerModemInfo = QConsumerModemInfo.consumerModemInfo;

    public MeterdailyRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public ResponseModemCount countByModemStatus() {

        return jpaQueryFactory.select(Projections.bean(
                ResponseModemCount.class,
                    new CaseBuilder().when(meterdaily.modem_battery.in(0, 1)).then(1).otherwise(0).sum().as("modemLowBatteryCnt"),
                    new CaseBuilder().when(meterdaily.time_sync.eq(0)).then(1).otherwise(0).sum().as("timeSyncCnt"),
                    meterdaily.modem_connect.sum().intValue().as("disconnectCnt")
                )
            )
            .from(meterdaily)
            .where(goeDailyDate())
            .fetchOne();
    }

    @Override
    public List<ResponseDashboardMap> findMapListByEquipState(RequestEquipState search) {

        return jpaQueryFactory.select(Projections.bean(
                ResponseDashboardMap.class,
                    consumerModemInfo.geo_x.as("geoX"),
                    consumerModemInfo.geo_y.as("geoY"),
                    consumerModemInfo.daum_x.as("daumX"),
                    consumerModemInfo.daum_y.as("daumY"),
                    consumerModemInfo.mng_id.as("mngId"),
                    consumerModemInfo.wateruser_type.as("waterUserType")
                )
            )
            .from(meterdaily)
            .leftJoin(consumerModemInfo)
            .on(meterdaily.meterdailyId.modem_id.eq(consumerModemInfo.modem_id))
            .where(getQueryByEquipState(search.getOmissionType()), goeDailyDate())
            .fetch();
    }

    @Override
    public int countByReceivingState(String receivingState) {
        Date fromDate = Timestamp.valueOf(LocalDate.now().minusDays(5).atStartOfDay());
        Date toDate = Timestamp.valueOf(LocalDate.now().atStartOfDay());
        return jpaQueryFactory
            .selectFrom(meterdaily)
            .where(meterdaily.meterdailyId.daily_date.goe(fromDate),
                meterdaily.meterdailyId.daily_date.loe(toDate),
                meterdaily.daily_tag.eq("N"))
            .groupBy(meterdaily.meterdailyId.modem_id)
            .having(getQueryByReceivingState(receivingState))
            .fetch().size();
    }

    @Override
    public List<ResponseDashboardMap> findMapListByReceivingState(RequestReceivingState search) {
        Date fromDate = Timestamp.valueOf(LocalDate.now().minusDays(5).atStartOfDay());
        Date toDate = Timestamp.valueOf(LocalDate.now().atStartOfDay());
        return jpaQueryFactory.select(Projections.bean(
                    ResponseDashboardMap.class,
                    consumerModemInfo.geo_x.as("geoX"),
                    consumerModemInfo.geo_y.as("geoY"),
                    consumerModemInfo.daum_x.as("daumX"),
                    consumerModemInfo.daum_y.as("daumY"),
                    consumerModemInfo.mng_id.as("mngId"),
                    consumerModemInfo.wateruser_type.as("waterUserType")
                )
            )
            .from(meterdaily)
            .leftJoin(consumerModemInfo)
            .on(meterdaily.meterdailyId.modem_id.eq(consumerModemInfo.modem_id))
            .where(meterdaily.meterdailyId.daily_date.goe(fromDate),
                meterdaily.meterdailyId.daily_date.loe(toDate),
                meterdaily.daily_tag.eq("N"))
            .groupBy(meterdaily.meterdailyId.modem_id)
            .having(getQueryByReceivingState(search.getStateType()))
            .fetch();
    }

    private BooleanExpression getQueryByEquipState(String equipState) {
        switch (equipState) {
            case "modemLowBattery":
                return meterdaily.modem_battery.in(0, 1);
            case "disConnect":
                return meterdaily.modem_connect.eq(BigDecimal.valueOf(1));
            case "timeSync":
                return meterdaily.time_sync.eq(0);
            case "overflow":
                return meterdaily.meter_overflow.eq(1);
            case "waterLeak":
                return meterdaily.meter_waterleak.eq(1);
            case "meterLowBattery":
                return meterdaily.meter_battery.in(1, 2);
        }
        return meterdaily.modem_battery.in(0, 1);
    }

    private BooleanExpression getQueryByReceivingState(String receivingState) {
        switch (receivingState) {
            case "normalReception": case "normal_reception":
                return meterdaily.daily_tag.count().intValue().goe(3);
            case "noReception": case "no_reception":
                return meterdaily.daily_tag.count().intValue().in(1, 2);
            case "longTermNoReception": case "longterm_no_reception":
                return meterdaily.daily_tag.count().intValue().eq(0);
        }
        return meterdaily.daily_tag.count().intValue().goe(3);
    }

    private BooleanExpression goeDailyDate() {
        Date nowDate = Timestamp.valueOf(LocalDate.now().atStartOfDay());

        return meterdaily.meterdailyId.daily_date.goe(nowDate);
    }
}
