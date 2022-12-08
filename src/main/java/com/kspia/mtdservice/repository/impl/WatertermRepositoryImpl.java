package com.kspia.mtdservice.repository.impl;

import com.kspia.mtdservice.repository.WatertermRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class WatertermRepositoryImpl implements WatertermRepository {
    private  final JPAQueryFactory jpaQueryFactory;

    public WatertermRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Long count() {
        return null;
    }
}
