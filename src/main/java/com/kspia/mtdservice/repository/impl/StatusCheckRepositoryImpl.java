package com.kspia.mtdservice.repository.impl;

import com.kspia.mtdservice.dto.SearchListDto;
import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.entity.QConsumerInstallInfo;
import com.kspia.mtdservice.entity.QMeterinfo;
import com.kspia.mtdservice.repository.StatusCheckRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2022. 12. 8
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 실시간 현황 조회 repositoryImpl 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 08 jung : 실시간 현황 조회 작업
 */
@Repository
public class StatusCheckRepositoryImpl implements StatusCheckRepository {
    private  final JPAQueryFactory jpaQueryFactory;

    public StatusCheckRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

//    @Override
//    public List<Long> countByTerm() {
//
//        QConsumerInstallInfo consumerInstallInfo = QConsumerInstallInfo.consumerInstallInfo;
//        return jpaQueryFactory.select(consumerInstallInfo.count()).from(consumerInstallInfo)
//                .fetch();
//    }


    @Override
    public List<StatusCheckDto> statusCheckByMetering() {

        QConsumerInstallInfo consumerInstallInfo = QConsumerInstallInfo.consumerInstallInfo;
        QMeterinfo meterinfo = QMeterinfo.meterinfo;


        return jpaQueryFactory.select(Projections.fields(StatusCheckDto.class,
                consumerInstallInfo.check_day.as("consumerCheckDay"),consumerInstallInfo.mng_id.as("consumerMngId"),
                consumerInstallInfo.wateruser_name.as("consumerWateruserName"),consumerInstallInfo.new_address.as("consumerNewAddress"),
                consumerInstallInfo.wateruser_id.as("consumerWateruserId"),consumerInstallInfo.wateruser_indust.as("consumerWateruserIndust"),
                consumerInstallInfo.wateruser_gauge.as("consumerWateruserGaugee"),consumerInstallInfo.wateruser_state.as("consumerWateruserState"),
                meterinfo.metering_value.as("infoMeteringValue"),meterinfo.metering_temp.as("infoMeteringTemp")
                ))
                .from(consumerInstallInfo)
                .join(meterinfo).on(consumerInstallInfo.modem_id.eq(meterinfo.modem_id))
                .fetch();
    }
}
