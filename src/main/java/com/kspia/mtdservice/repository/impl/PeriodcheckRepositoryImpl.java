package com.kspia.mtdservice.repository.impl;

import com.kspia.mtdservice.dto.PeriodcheckDto;
import com.kspia.mtdservice.entity.QConsumerModemInfo;
import com.kspia.mtdservice.entity.QMeterdaily;
import com.kspia.mtdservice.repository.PeriodcheckRepository;
import com.kspia.mtdservice.vo.RequestPeriodUsageVO;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @since 2022. 12. 21
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 사용량 기간조회 RepositoryImpl 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12.21 jung: 최초 작성
 * 2022.12.21 jung : 사용량 기간조회 RepositoryImpl 작업
 * 2022.12.22 jung : 사용량 기간조회 RepositoryImpl 쿼리문 작성
 */

@Repository
public class PeriodcheckRepositoryImpl implements PeriodcheckRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public PeriodcheckRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    QConsumerModemInfo consumerModemInfo = QConsumerModemInfo.consumerModemInfo;
    QMeterdaily meterdaily = QMeterdaily.meterdaily;

    @Override
    @NotNull
    public Page<PeriodcheckDto> periodcheckByList(RequestPeriodUsageVO us, Pageable pageable) {
        List<PeriodcheckDto> results =
                jpaQueryFactory.select(Projections.fields(PeriodcheckDto.class,
                        consumerModemInfo.mng_id.as("mngId"), consumerModemInfo.wateruser_name.as("consumerName"),
                        consumerModemInfo.dong_nm.as("dongName"), consumerModemInfo.area_id.as("bunguName"),
                        meterdaily.meterdailyId.daily_date.as("startDate"),
                        meterdaily.meterdailyId.daily_date.as("endDate"),
                        meterdaily.past_value.min().as("startValue"), meterdaily.new_value.max().as("endValue"),
                        meterdaily.daily_usage.sum().as("meteringUsage")
                ))
                .from(consumerModemInfo).join(meterdaily).groupBy(meterdaily.meterdailyId.modem_id)
                .on(consumerModemInfo.modem_id.eq(meterdaily.meterdailyId.modem_id))
                .where(searchDateFilter(us.getFromDate(), us.getToDate()),eqMngId(us.getMngId()),
                        eqConsumerName(us.getConsumerName()), eqNewAddress(us.getNewAddress()),
                        eqAreaId(us.getAreaId()), eqDongId(us.getDongId()))
                .offset(us.getPage() * us.getSize())
                .limit(us.getSize())
                .fetch();
        System.out.println(searchDateFilter(us.getFromDate(), us.getToDate()));
        long total = jpaQueryFactory.select(consumerModemInfo.count()).from(consumerModemInfo)
                .join(meterdaily).on(consumerModemInfo.modem_id.eq(meterdaily.meterdailyId.modem_id))
                .where(eqFromDate(us.getFromDate()), eqToDate(us.getToDate()), eqMngId(us.getMngId()),
                        eqConsumerName(us.getConsumerName()), eqNewAddress(us.getNewAddress()),
                        eqAreaId(us.getAreaId()), eqDongId(us.getDongId()))
                .fetchOne();
        Pageable pageable1 = PageRequest.of(us.getPage(), us.getSize(), Sort.by("asc"));
        return new PageImpl<>(results, pageable1, total);
    }

    private BooleanExpression searchDateFilter(LocalDateTime searchFromDate, LocalDateTime searchToDate) {

        //goe, loe 사용
        BooleanExpression isGoeStartDate = meterdaily.meterdailyId.daily_date.goe(LocalDate.from(LocalDateTime.of(LocalDate.from(searchFromDate), LocalTime.MIN)));
        BooleanExpression isLoeEndDate = meterdaily.meterdailyId.daily_date.loe(LocalDate.from(LocalDateTime.of(LocalDate.from(searchToDate), LocalTime.MAX).withNano(0)));

        return Expressions.allOf(isGoeStartDate, isLoeEndDate);
    }

    private BooleanExpression eqFromDate(LocalDateTime fromDate) {
        if (fromDate == null) {
            return null;
        }
        LocalDate localFromDate = LocalDate.from(fromDate);
        return meterdaily.meterdailyId.daily_date.eq(localFromDate);
    }

    private BooleanExpression eqToDate(LocalDateTime toDate) {
        if (toDate == null) {
            return null;
        }
        LocalDate localToDate = LocalDate.from(toDate);
        return meterdaily.meterdailyId.daily_date.eq(localToDate);
    }

    private BooleanExpression eqMngId(String mngId) {
        if (mngId == null || mngId == "") {
            return null;
        }
        return consumerModemInfo.mng_id.eq(mngId);
    }

    private BooleanExpression eqConsumerName(String consumerName) {
        if (consumerName == null || consumerName == "") {
            return null;
        }
        return consumerModemInfo.wateruser_name.eq(consumerName);
    }

    private BooleanExpression eqNewAddress(String newAddress) {
        if (newAddress == null || newAddress == "") {
            return null;
        }
        return consumerModemInfo.new_address.eq(newAddress);
    }

    private BooleanExpression eqAreaId(String areaId) {
        if (areaId == null || areaId.equals("00")) {
            return null;
        }
        return consumerModemInfo.area_id.eq(areaId);
    }

    private BooleanExpression eqDongId(String dongId) {
        if (dongId == null || dongId == "") {
            return null;
        }
        return consumerModemInfo.dong_nm.eq(dongId);
    }
}
