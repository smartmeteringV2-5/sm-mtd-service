package com.kspia.mtdservice.repository.impl;

import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.entity.QConsumerInstallInfo;
import com.kspia.mtdservice.entity.QConsumerModemInfo;
import com.kspia.mtdservice.entity.QMeterdaily;
import com.kspia.mtdservice.repository.StatusCheckRepository;
import com.kspia.mtdservice.vo.RequestUsageHistoryVO;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author jung
 * @Discript ---------------------------------------------------
 * 개요 : 실시간 현황 조회 repositoryImpl 생성
 * ---------------------------------------------------
 * @EditHIstory 개정이력
 * 2022.12. 09 jung : 최초 작성
 * 2022.12. 12 jung : 실시간 현황 조회 작업 리스트 검색 쿼리문 작성
 * 2022.12. 14 jung : 실시간 현황 조회 작업 리스트 검색 수정
 * @since 2022. 12. 9
 */
@Repository
public class StatusCheckRepositoryImpl implements StatusCheckRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public StatusCheckRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    QConsumerModemInfo consumerInstallInfo = QConsumerModemInfo.consumerModemInfo;
    QMeterdaily meterdaily = QMeterdaily.meterdaily;

    //실시간 현황 조회 검색 리스트
    @Override
    @NotNull
    public Page<StatusCheckDto> statusCheckByMetering(RequestUsageHistoryVO sl, Pageable pageable) {
        List<StatusCheckDto> results = jpaQueryFactory.select(Projections.fields(StatusCheckDto.class,
                        consumerInstallInfo.check_day.as("checkDay"),
                        consumerInstallInfo.mng_id.as("mngId"),
                        consumerInstallInfo.wateruser_name.as("consumerName"),
                        consumerInstallInfo.new_address.as("newAddress"),
                        consumerInstallInfo.wateruser_id.as("waterUserId"),
                        consumerInstallInfo.wateruser_indust.as("waterUserIndust"),
                        consumerInstallInfo.wateruser_gauge.as("consumerCaliber"),
                        meterdaily.new_value.as("new_value"),
                        new CaseBuilder().when(meterdaily.meter_backflow.eq("0")).then("정상").otherwise("역류").as("backflow"),
                        new CaseBuilder().when(meterdaily.meter_battery.in("1,2")).then("저전압").otherwise("정상").as("meterBattery"),
                        new CaseBuilder().when(meterdaily.meter_overflow.eq("0")).then("정상").otherwise("과부화").as("overflow"),
                        new CaseBuilder().when(meterdaily.meter_waterleak.eq("0")).then("정상").otherwise("누수").as("waterleak"),
                        new CaseBuilder().when(meterdaily.modem_battery.in("0,1")).then("저전압").otherwise("정상").as("modemBattery"),
                        new CaseBuilder().when(meterdaily.modem_connect.eq("0")).then("정상").otherwise("통신불량").as("disconnected"),
                        new CaseBuilder().when(meterdaily.time_sync.eq("1")).then("정상").otherwise("오류").as("timeSync"),
                        meterdaily.modem_rssi.as("modem_rssi"),meterdaily.metering_date.as("meteringDate"),
                        consumerInstallInfo.wateruser_state.as("waterUserState")
                ))
                .from(consumerInstallInfo)
                .join(meterdaily)
                .on(consumerInstallInfo.modem_id.eq(meterdaily.meterdailyId.modem_id))
                .where(eqAreaId(sl.getAreaId()), eqCheckDay(sl.getCheckDay()), eqDailyDate(sl.getFromDate()),
                        eqDongNm(sl.getDongId()), eqBunguId(sl.getBunguId()), eqMngId(sl.getMngId()),
                        eqWateruserName(sl.getConsumerName()), eqNewAddress(sl.getNewAddress()),
                        eqConsumerState(sl.getConsumerState()), eqBackflow(sl.getMeteringSignalStatus()),
                        eqMeterBattery(sl.getMeteringSignalStatus()), eqOverflow(sl.getModemSignalStatus()),
                        eqTimeSync(sl.getModemSignalStatus()), eqModemBattery(sl.getModemSignalStatus()), eqConsumerCaliber(sl.getConsumerCaliber()))
                //
                .offset(pageable.getOffset()) /*offset*/
                .limit(pageable.getPageSize())
                .fetch();
                //페이지 총 카운트 구하기
                long total = jpaQueryFactory.select(consumerInstallInfo.count()).from(consumerInstallInfo)
                        .join(meterdaily).on(consumerInstallInfo.modem_id.eq(meterdaily.meterdailyId.modem_id))
                        .where(eqAreaId(sl.getAreaId()), eqCheckDay(sl.getCheckDay()), eqDailyDate(sl.getFromDate()),
                                eqDongNm(sl.getDongId()), eqBunguId(sl.getBunguId()), eqMngId(sl.getMngId()),
                                eqWateruserName(sl.getConsumerName()), eqNewAddress(sl.getNewAddress()),
                                eqConsumerState(sl.getConsumerState()), eqBackflow(sl.getMeteringSignalStatus()),
                                eqMeterBattery(sl.getMeteringSignalStatus()), eqOverflow(sl.getMeteringSignalStatus()),
                                eqWaterleak(sl.getMeteringSignalStatus()),eqDisconnected(sl.getModemSignalStatus()),
                                eqTimeSync(sl.getModemSignalStatus()), eqModemBattery(sl.getModemSignalStatus()),
                                eqConsumerCaliber(sl.getConsumerCaliber()))
                        .fetchOne();

        return new PageImpl<>(results, pageable, total);
    }


    private BooleanExpression eqAreaId(String areaId) {
        if (areaId == null || areaId.equals("00")) {
            return null;
        }
        return consumerInstallInfo.area_id.eq(areaId);
    }

    private BooleanExpression eqCheckDay(String checkDay) {
        if (checkDay == null || checkDay == "") {
            return null;
        }
        return consumerInstallInfo.check_day.eq(checkDay);
    }

    private BooleanExpression eqDailyDate(LocalDateTime dailyDate) {
        if (dailyDate == null) {
            return null;
        }
        LocalDate localDailyDate = LocalDate.from(dailyDate);
        return meterdaily.meterdailyId.daily_date.eq(localDailyDate);
    }

    private BooleanExpression eqDongNm(String dongNm) {
        if (dongNm == null || dongNm == "") {
            return null;
        }
        return consumerInstallInfo.dong_nm.eq(dongNm);
    }

    private BooleanExpression eqBunguId(String bunguId) {
        if (bunguId == null || bunguId == "") {
            return null;
        }
        return consumerInstallInfo.dividarea.eq(bunguId);
    }

    private BooleanExpression eqMngId(String mngId) {
        if (mngId == null || mngId == "") {
            return null;
        }
        return consumerInstallInfo.mng_id.eq(mngId);
    }

    private BooleanExpression eqWateruserName(String wateruserName) {
        if (wateruserName == null || wateruserName == "") {
            return null;
        }
        return consumerInstallInfo.wateruser_name.eq(wateruserName);
    }

    private BooleanExpression eqNewAddress(String newAddress) {
        if (newAddress == null || newAddress == "") {
            return null;
        }
        return consumerInstallInfo.new_address.eq(newAddress);
    }
    private BooleanExpression eqConsumerState(String consumerState) {
        if (consumerState == null || consumerState == "") {
            return null;
        }
        switch (consumerState) {
            case "CST0201000" :
                consumerState = "정상";
                break;
            case "CST0202000" :
                consumerState = "설치대기";
                break;
            case "CST0203000" :
                consumerState = "정수처분";
                break;
            case "CST0204000" :
                consumerState = "급수정지";
                break;
            case "CST0205000" :
                consumerState = "폐전";
                break;
            case "CST0206000" :
                consumerState = "구경확대";
                break;
            case "CST0207000" :
                consumerState = "기계식";
                break;
            case "CST0208000" :
                consumerState = "체납";
                break;
        }
        return consumerInstallInfo.wateruser_state.eq(consumerState);
    }

    private BooleanExpression eqBackflow(String backflow) {
        if (backflow == null || backflow == "") {
            return null;
        }
        return meterdaily.meter_backflow.eq((backflow));
    }

    private BooleanExpression eqMeterBattery(String meterBattery) {
        if (meterBattery == null || meterBattery == "") {
            return null;
        }
        return meterdaily.meter_battery.eq(meterBattery);
    }

    private BooleanExpression eqOverflow(String overflow) {
        if (overflow == null || overflow == "") {
            return null;
        }
        return meterdaily.meter_overflow.eq(overflow);
    }

    private BooleanExpression eqWaterleak(String waterleak) {
        if (waterleak == null || waterleak == "") {
            return null;
        }
        return meterdaily.meter_waterleak.eq(waterleak);
    }

//    private BooleanExpression eqModemRssi(String modemRssi) {
//        if (modemRssi == null) {
//            return null;
//        }
//        return meterdaily.modem_rssi.eq(modemRssi);
//    }

    private BooleanExpression eqDisconnected(String disconnected) {
        if (disconnected == null || disconnected == "") {
            return null;
        }
        return meterdaily.modem_connect.eq(disconnected);
    }

    private BooleanExpression eqTimeSync(String timeSync) {
        if (timeSync == null || timeSync == "") {
            return null;
        }
        return meterdaily.time_sync.eq(timeSync);
    }

    private BooleanExpression eqModemBattery(String modemBattery) {
        if (modemBattery == null || modemBattery == "") {
            return null;
        }
        return meterdaily.modem_battery.eq(modemBattery);
    }

    private BooleanExpression eqConsumerCaliber(String consumerCaliber) {
        if (consumerCaliber == null || consumerCaliber == "") {
            return null;
        }
        return consumerInstallInfo.wateruser_gauge.eq(consumerCaliber);
    }

}
