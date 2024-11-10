package com.heon9u.rcs.study.common;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DataCleaner implements InitializingBean {

    @PersistenceContext
    private EntityManager em;
    private List<String> tableNames = new ArrayList<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        List<Object> tableInfos = em.createNativeQuery("SHOW TABLES FROM rcs").getResultList();
        log.debug("{}", tableInfos);

        for(Object table: tableInfos) {
            String name = table.toString();
            tableNames.add(name);
        }
    }

    @Transactional
    public void init() {
        em.flush();

//        em.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
        for(String name: tableNames) {
            em.createNativeQuery("TRUNCATE TABLE " + name).executeUpdate();
        }
//        em.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();
    }
}
