package com.norulesweb.studenttracker.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Repository factory bean for custom Simulator repository
 *
 * @param <T>
 * @param <S>
 * @param <ID>
 */

public class StudentTrackerRepositoryFactoryBean <T extends JpaRepository<S, ID>, S, ID extends Serializable>
        extends JpaRepositoryFactoryBean<T, S, ID> {
    /**
     * Returns a {@link RepositoryFactorySupport}.
     *
     * @param entityManager
     * @return
     */
    protected RepositoryFactorySupport createRepositoryFactory(
            EntityManager entityManager) {

        return new StudentTrackerRepositoryFactory<T, ID>(entityManager);
    }

}
