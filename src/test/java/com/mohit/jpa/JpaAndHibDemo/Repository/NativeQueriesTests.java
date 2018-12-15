package com.mohit.jpa.JpaAndHibDemo.Repository;

import com.mohit.jpa.JpaAndHibDemo.JpaAndHibDemoApplication;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RunWith(SpringRunner.class) // Is used to launch a Spring-Context
@SpringBootTest(classes = JpaAndHibDemoApplication.class) //It would launch an entire context
public class NativeQueriesTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager entityManager;

    @Test
    public void native_queries_basic() {
        Query query = entityManager.createNativeQuery("Select * from Course", Course.class);
        List resultList = query.getResultList();
        logger.info("Select c from Course c -{}", resultList);
    }


}
