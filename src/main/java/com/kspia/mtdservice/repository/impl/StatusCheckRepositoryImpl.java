package com.kspia.mtdservice.repository.impl;

import com.kspia.mtdservice.dto.SearchListDto;
import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.entity.QConsumerInstallInfo;
import com.kspia.mtdservice.entity.QMeterdaily;
import com.kspia.mtdservice.repository.StatusCheckRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @since 2022. 12. 9
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 실시간 현황 조회 repositoryImpl 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 09 jung : 최초 작성
 * 2022.12. 12 jung : 실시간 현황 조회 작업 리스트 검색
 */
@Repository
public class StatusCheckRepositoryImpl implements StatusCheckRepository {
    private  final JPAQueryFactory jpaQueryFactory;

    public StatusCheckRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    QConsumerInstallInfo consumerInstallInfo = QConsumerInstallInfo.consumerInstallInfo;
    QMeterdaily meterdaily = QMeterdaily.meterdaily;

//실시간 현황 조회 검색 리스트
    @Override
    public List<StatusCheckDto> statusCheckByMetering(SearchListDto sl) {

        return jpaQueryFactory.select(Projections.fields(StatusCheckDto.class,
                        consumerInstallInfo.check_day.as("check_day"), consumerInstallInfo.mng_id.as("mng_id"),
                        consumerInstallInfo.wateruser_name.as("wateruser_name"),consumerInstallInfo.new_address.as("new_address"),
                        consumerInstallInfo.wateruser_id.as("wateruser_id"),consumerInstallInfo.wateruser_indust.as("wateruser_indust"),
                        consumerInstallInfo.wateruser_gauge.as("wateruser_gauge"),consumerInstallInfo.wateruser_state.as("wateruser_state"),
                        meterdaily.meter_backflow.as("meter_backflow"),meterdaily.meter_battery.as("meter_battery"),
                        meterdaily.meter_overflow.as("meter_overflow"),meterdaily.meter_waterleak.as("meter_waterleak"),
                        meterdaily.modem_battery.as("modem_battery"),meterdaily.modem_connect.as("modem_connect"),
                        meterdaily.modem_rssi.as("modem_rssi"),meterdaily.time_sync.as("time_sync"),
                        meterdaily.metering_date.as("metering_date")
                ))
                .from(consumerInstallInfo)
                .join(meterdaily).on(consumerInstallInfo.modem_id.eq(meterdaily.meterdailyId.modem_id))
                .where(eqAreaId(sl.getAreaId()), eqCheckDay(sl.getCheckDay()),eqDailyDate(sl.getDailyDate()),
                        eqDongNm(sl.getDongNm()),eqDividarea(sl.getDividarea()),eqMngId(sl.getMngId()),
                        eqWateruserName(sl.getWateruserName()),eqNewAddress(sl.getNewAddress()),
                        eqWateruserState(sl.getWateruserState()),eqMeterBackflow(sl.getMeter_backflow()),
                        eqMeterBattery(sl.getMeter_battery()),eqMeterOverflow(sl.getMeter_overflow()),
                        eqMeterWaterleak(sl.getMeter_waterleak()),eqModemRssi(sl.getModem_rssi()),eqMdoemConnect(sl.getModem_connect()),
                        eqTimeSync(sl.getTime_sync()),eqModemBattery(sl.getModem_battery()),eqWateruserGauge(sl.getWateruserGauge()))
                .fetch();
    }

    private BooleanExpression eqAreaId(String areaId){
        if(areaId == null){
            return null;
        }
        return consumerInstallInfo.area_id.eq(areaId);
    }

    private BooleanExpression eqCheckDay(String checkDay){
        if(checkDay == null){
            return null;
        }
        return consumerInstallInfo.check_day.eq(checkDay);
    }

    private BooleanExpression eqDailyDate(Date dayilyDate){
        if(dayilyDate == null){
            return null;
        }
        return meterdaily.meterdailyId.daily_date.eq(dayilyDate);
    }

    private BooleanExpression eqDongNm(String dongNm){
        if(dongNm == null){
            return null;
        }
        return consumerInstallInfo.dong_nm.eq(dongNm);
    }

    private BooleanExpression eqDividarea(String dividarea){
        if(dividarea == null){
            return null;
        }
        return consumerInstallInfo.dividarea.eq(dividarea);
    }

    private BooleanExpression eqMngId(String mngId){
        if(mngId == null){
            return null;
        }
        return consumerInstallInfo.mng_id.eq(mngId);
    }

    private BooleanExpression eqWateruserName(String wateruserName){
        if(wateruserName == null){
            return null;
        }
        return consumerInstallInfo.wateruser_name.eq(wateruserName);
    }

    private BooleanExpression eqNewAddress(String newAddress){
        if(newAddress == null){
            return null;
        }
        return consumerInstallInfo.new_address.eq(newAddress);
    }

    private BooleanExpression eqWateruserState(String wateruserState){
        if(wateruserState == null){
            return null;
        }
        return consumerInstallInfo.wateruser_state.eq(wateruserState);
    }

    private BooleanExpression eqMeterBackflow(Integer meterBackflow){
        if(meterBackflow == null){
            return null;
        }
        return meterdaily.meter_backflow.eq(meterBackflow);
    }

    private BooleanExpression eqMeterBattery(Integer meterBattery){
        if(meterBattery == null){
            return null;
        }
        return meterdaily.meter_battery.eq(meterBattery);
    }

    private BooleanExpression eqMeterOverflow(Integer meterOverflow){
        if(meterOverflow == null){
            return null;
        }
        return meterdaily.meter_overflow.eq(meterOverflow);
    }

    private BooleanExpression eqMeterWaterleak(Integer meterWaterleak){
        if(meterWaterleak == null){
            return null;
        }
        return meterdaily.meter_waterleak.eq(meterWaterleak);
    }

    private BooleanExpression eqModemRssi(String modemRssi){
        if(modemRssi == null){
            return null;
        }
        return meterdaily.modem_rssi.eq(modemRssi);
    }

    private BooleanExpression eqMdoemConnect(BigDecimal modemConnect){
        if(modemConnect == null){
            return null;
        }
        return meterdaily.modem_connect.eq(modemConnect);
    }

    private BooleanExpression eqTimeSync(Integer timeSync){
        if(timeSync == null){
            return null;
        }
        return meterdaily.time_sync.eq(timeSync);
    }

    private BooleanExpression eqModemBattery(BigDecimal modemBattery){
        if(modemBattery == null){
            return null;
        }
        return meterdaily.modem_battery.eq(modemBattery);
    }

    private BooleanExpression eqWateruserGauge(String wateruserGauge){
        if(wateruserGauge == null){
            return null;
        }
        return consumerInstallInfo.wateruser_gauge.eq(wateruserGauge);
    }






}
