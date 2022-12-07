package com.kspia.mtdservice;

import com.kspia.mtdservice.entity.ConsumerModemInfo;
import com.kspia.mtdservice.entity.QConsumerModemInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class SmMtdServiceApplicationTests {

    @Autowired
    EntityManager em;

    @Test
    void contextLoads() {
        ConsumerModemInfo info = new ConsumerModemInfo();
        em.persist(info);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QConsumerModemInfo qInfo = new QConsumerModemInfo("c");

        ConsumerModemInfo result = query
                .selectFrom(qInfo)
                .fetchOne();

        Assertions.assertThat(result.getConsumer_sid()).isEqualTo(info.getConsumer_sid());
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager em) {
        return new JPAQueryFactory(em);
    }

}
