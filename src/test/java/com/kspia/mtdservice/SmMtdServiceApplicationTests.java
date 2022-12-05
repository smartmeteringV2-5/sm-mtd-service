package com.kspia.mtdservice;

import com.kspia.mtdservice.jpa.ConsumerModemInfoEntity;
import com.kspia.mtdservice.jpa.QConsumerModemInfoEntity;
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
        ConsumerModemInfoEntity info = new ConsumerModemInfoEntity();
        em.persist(info);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QConsumerModemInfoEntity qInfo = new QConsumerModemInfoEntity("c");

        ConsumerModemInfoEntity result = query
                .selectFrom(qInfo)
                .fetchOne();

        Assertions.assertThat(result.getConsumer_sid()).isEqualTo(info.getConsumer_sid());
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager em) {
        return new JPAQueryFactory(em);
    }

}
