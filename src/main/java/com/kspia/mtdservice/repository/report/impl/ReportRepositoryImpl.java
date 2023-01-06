package com.kspia.mtdservice.repository.report.impl;

import com.kspia.mtdservice.dto.report.ReportDto;
import com.kspia.mtdservice.entity.report.QMeterDataSeoulNbiot;
import com.kspia.mtdservice.repository.report.ReportRepository;
import com.kspia.mtdservice.vo.report.RequestReportVo;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @since 2023. 01. 04
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 검침값 확인 레파지토리임플 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2023.01.04 jung: 최초 작성
 * 2023.01.05 jung : 검침값 확인 쿼리 작성
 */
@Repository
public class ReportRepositoryImpl implements ReportRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public ReportRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }
    QMeterDataSeoulNbiot meterDataSeoulNbiot = QMeterDataSeoulNbiot.meterDataSeoulNbiot;
    @Override
    @NotNull
    public Page<ReportDto> reportCheckByList(RequestReportVo re, Pageable pageable) {

        List<ReportDto> results = jpaQueryFactory.select(Projections.fields(ReportDto.class,
                meterDataSeoulNbiot.meterDataSeoulNbiotId.imei.as("imei"),
                meterDataSeoulNbiot.meterDataSeoulNbiotId.metering_date.as("meteringDate"),
                new CaseBuilder().when(meterDataSeoulNbiot.modem_battery.between(2.000, 4.000)).then("정상")
                        .otherwise("저전압").as("modemBattery"),
                new CaseBuilder().when(meterDataSeoulNbiot.metering_value.eq(-99.000)).then("결선")
                        .otherwise("정상").as("meteringValue")
                ))
                .from(meterDataSeoulNbiot)
                .where(eqImei(re.getImei()),eqMeteringDate(re.getMeteringDate()),eqModemBattery(re.getModemBattery()),
                        eqMeteringValue(re.getMeteringValue()))
                .offset(re.getPage() * re.getSize())
                .limit(re.getSize())
                .fetch();
        long total = jpaQueryFactory.select(meterDataSeoulNbiot.count()).from(meterDataSeoulNbiot)
                .where(eqImei(re.getImei()),eqMeteringDate(re.getMeteringDate()),eqModemBattery(re.getModemBattery()),
                        eqMeteringValue(re.getMeteringValue()))
                .fetchOne();
        Pageable pageable1 = PageRequest.of(re.getPage(), re.getSize(), Sort.by("asc"));
        return new PageImpl<>(results, pageable1, total);
    }

    private BooleanExpression eqImei(String imei) {
        if (imei == null || imei == "") {
            return null;
        }
        return meterDataSeoulNbiot.meterDataSeoulNbiotId.imei.eq(imei);
    }

    private BooleanExpression eqMeteringDate(LocalDateTime meteringDate){
        if (meteringDate == null) {
            return null;
        }
        LocalDate localMeteringDate = LocalDate.from(meteringDate);
        return meterDataSeoulNbiot.meterDataSeoulNbiotId.metering_date.eq(localMeteringDate);
    }

    private BooleanExpression eqModemBattery(String modemBattery){
        if (modemBattery == null || modemBattery == "") {
            return null;
        }
        System.out.println(modemBattery);
        return meterDataSeoulNbiot.modem_battery.eq(Double.valueOf(modemBattery));
    }

    private BooleanExpression eqMeteringValue(String meteringValue) {
        if (meteringValue == null || meteringValue == "") {
            return null;
        }
        return meterDataSeoulNbiot.metering_value.eq(Double.valueOf(meteringValue));
    }
}
