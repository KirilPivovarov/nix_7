package ua.com.alevel.crud;

import ua.com.alevel.BaseClass;

import java.util.Collection;

public interface BaseDao<B extends BaseClass> {

    void create(B b);
    void update(B b);
    void delete(Long id);
    B getById(Long id);
    Collection<B> getAll();
}
