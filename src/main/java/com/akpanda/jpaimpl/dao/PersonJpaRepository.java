package com.akpanda.jpaimpl.dao;

import com.akpanda.jpaimpl.entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }

    public Person updatePerson(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        Person person = findById(id);
        entityManager.remove(person);
    }

    public List<Person> findAll(){
        TypedQuery<Person> typedQuery =  entityManager.createNamedQuery("find_all_personss",Person.class);
        return typedQuery.getResultList();
    }
}
