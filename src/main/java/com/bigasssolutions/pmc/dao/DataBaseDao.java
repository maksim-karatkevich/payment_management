package com.bigasssolutions.pmc.dao;

import java.util.List;

/**
 * Created by Maksim on 11/15/2017.
 */
public interface DataBaseDao <T>{
    void save(T entity);
    List<T> findAll();
    void update();
    T findById(long id);
}
