package com.kspia.mtdservice.repository.impl;

import com.kspia.mtdservice.dto.MeterdailyDto;
import com.kspia.mtdservice.dto.MeterdailyDto.EquipStateMap;
import com.kspia.mtdservice.dto.MeterdailyDto.ModemCount;
import com.kspia.mtdservice.entity.QConsumerModemInfo;
import com.kspia.mtdservice.entity.QMeterdaily;
import com.kspia.mtdservice.repository.MeterdailyRepository;
import com.kspia.mtdservice.vo.RequestSearch;
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
    public ModemCount countByModemStatus() {

        return jpaQueryFactory.select(Projections.bean(
                    MeterdailyDto.ModemCount.class,
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
    public List<EquipStateMap> findMapListByEquipState(RequestSearch search) {

        return jpaQueryFactory.select(Projections.bean(
                    MeterdailyDto.EquipStateMap.class,
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
//        return throw new DataNotFoundException("선택된 항목이 없습니다.");
    }

    private BooleanExpression goeDailyDate() {
        Date nowDate = Timestamp.valueOf(LocalDate.now().atStartOfDay());

        return meterdaily.meterdailyId.daily_date.goe(nowDate);
    }
}
