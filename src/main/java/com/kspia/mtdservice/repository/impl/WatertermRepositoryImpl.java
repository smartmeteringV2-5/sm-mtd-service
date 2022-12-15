package com.kspia.mtdservice.repository.impl;

import com.kspia.mtdservice.entity.QConsumerInstallInfo;
import com.kspia.mtdservice.entity.QConsumerModemInfo;
import com.kspia.mtdservice.repository.WatertermRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2022. 12. 8
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 단말기 카운트 작업 repositoryImpl 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 08 jung : 단말기 카운트 작업
 */
@Repository
public class WatertermRepositoryImpl implements WatertermRepository {
    private  final JPAQueryFactory jpaQueryFactory;

    public WatertermRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Long countByTerm() {

        QConsumerModemInfo consumerModemInfo = QConsumerModemInfo.consumerModemInfo;
        return jpaQueryFactory.select(consumerModemInfo.modem_id.count()).from(consumerModemInfo)
                .fetchOne();
    }
}
