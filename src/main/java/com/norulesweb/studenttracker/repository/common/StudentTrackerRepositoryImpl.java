package com.norulesweb.studenttracker.repository.common;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class StudentTrackerRepositoryImpl<T, ID extends Serializable> extends QueryDslJpaRepository<T, ID> implements StudentTrackerRepository<T, ID> {

    private final EntityManager entityManager;

    public StudentTrackerRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
    }

    @Override
    public void refresh(T model) { entityManager.refresh(model); }

    @Override
    public void flushAndRefresh(T model) {
        entityManager.flush();
        refresh(model);
    }

}
