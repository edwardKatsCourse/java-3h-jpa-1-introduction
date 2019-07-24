package com.example.repository;

import com.example.model.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person save(Person p) {
        if (p.getId() == null) {
            entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }
        return p;
    }

    @Override
    public void delete(Person p) {
        entityManager.remove(p);
    }

    @Override
    public List<Person> findAll() {
        TypedQuery<Person> query = entityManager.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }

    @Override
    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }
}
