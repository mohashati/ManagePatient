package com.managePatient.services;

import org.springframework.stereotype.Repository;

/**
 * Created by tmoshasha on 2017/10/12.
 */

@Repository
public interface BasicCrudService<E,ID> {
        E save(E entity);
        E findById(ID id);
        E update(E entity);
        void delete(E entity);
        Iterable<E> readAll();
    }





