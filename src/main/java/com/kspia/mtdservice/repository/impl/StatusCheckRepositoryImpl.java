package com.kspia.mtdservice.repository.impl;

import com.kspia.mtdservice.dto.SearchListDto;
import com.kspia.mtdservice.entity.QConsumerInstallInfo;
import com.kspia.mtdservice.repository.StatusCheckRepository;
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
public class StatusCheckRepositoryImpl implements StatusCheckRepository {
    private  final JPAQueryFactory jpaQueryFactory;

    public StatusCheckRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Long> countByTerm() {

        QConsumerInstallInfo consumerInstallInfo = QConsumerInstallInfo.consumerInstallInfo;
        return jpaQueryFactory.select(consumerInstallInfo.count()).from(consumerInstallInfo)
                .fetch();
    }

    @Override
    public List<SearchListDto> statusCheckByMetering() {
        return null;
    }
}
