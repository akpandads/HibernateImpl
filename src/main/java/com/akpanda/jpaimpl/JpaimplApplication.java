package com.akpanda.jpaimpl;

import com.akpanda.jpaimpl.dao.PersonJdbcDao;
import com.akpanda.jpaimpl.dao.PersonJpaRepository;
import com.akpanda.jpaimpl.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.function.Supplier;

@SpringBootApplication
public class JpaimplApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcDao personJdbcDao;

    @Autowired
    PersonJpaRepository personJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaimplApplication.class, args);
    }


    /*@Override
    public void run(String... args) throws Exception {
        logger.info("All Users" + personJdbcDao.findAll());
        logger.info("User id 1001 :" + personJdbcDao.findById(1001));
        logger.info("Deleted User  :" + personJdbcDao.findById(1002));
        logger.info("InsertUser User  :" + personJdbcDao.insertPerson(new Person(1004,"asas","asasa",new Date())));
        logger.info("InsertUser User  :" + personJdbcDao.updatePerson(new Person(1003,"asasds","asasdsda",new Date())));

    }*/

    @Override
    public void run(String... args) throws Exception {
        logger.info("User id 1001 :" + personJpaRepository.findById(1001));
        logger.info("InsertUser User  :" + personJpaRepository.updatePerson(new Person( 1004,"asas","asasa",new Date())));
        logger.info("InsertUser User  :" + personJpaRepository.updatePerson(new Person(1003,"asasds","asasdsda",new Date())));
        personJpaRepository.deleteById(1002);
        logger.info("All persons "+personJpaRepository.findAll());
    }
}
