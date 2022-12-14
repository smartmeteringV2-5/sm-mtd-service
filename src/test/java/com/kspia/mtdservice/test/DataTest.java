package com.kspia.mtdservice.test;

import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.entity.ConsumerInstallInfo;
import com.kspia.mtdservice.entity.QConsumerInstallInfo;
import com.kspia.mtdservice.entity.QMeterdaily;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
public class DataTest {
    @Autowired
    EntityManager em;
    JPAQueryFactory queryFactory;

    @BeforeEach
    public void init() {
        queryFactory = new JPAQueryFactory(em);
    }

    @Test
    public List<StatusCheckDto> helloQueryFactory() {
        QConsumerInstallInfo consumerInstallInfo = QConsumerInstallInfo.consumerInstallInfo;
        QMeterdaily meterdaily = QMeterdaily.meterdaily;


        return queryFactory.select(Projections.fields(StatusCheckDto.class,
                        consumerInstallInfo.check_day.as("check_day"),consumerInstallInfo.mng_id.as("consumerMngId"),
                        consumerInstallInfo.wateruser_name.as("consumerWateruserName"),consumerInstallInfo.new_address.as("consumerNewAddress"),
                        consumerInstallInfo.wateruser_id.as("consumerWateruserId"),consumerInstallInfo.wateruser_indust.as("consumerWateruserIndust"),
                        consumerInstallInfo.wateruser_gauge.as("consumerWateruserGaugee"),consumerInstallInfo.wateruser_state.as("consumerWateruserState"),
                        meterdaily.meter_backflow.as("dailyMeterBackflow"),meterdaily.meter_battery.as("dailyMeterBattery"),
                        meterdaily.meter_overflow.as("dailyMeterOverflow"),meterdaily.meter_waterleak.as("dailyMeterLeak"),
                        meterdaily.modem_battery.as("dailyModemBattery"),meterdaily.modem_connect.as("dailyModemCon"),
                        meterdaily.modem_rssi.as("dailyModemRssi"),meterdaily.time_sync.as("dailyTime"),
                        meterdaily.metering_date.as("dailyMeterDate")
                ))
                .from(consumerInstallInfo, meterdaily)
                .where(consumerInstallInfo.modem_id.eq(meterdaily.meterdailyId.modem_id))
                .fetch();
    }
}
