package ua.com.alevel.crud.impl;

import ua.com.alevel.BaseClass;
import ua.com.alevel.crud.BaseDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Deprecated
public class InMemoryDao<B extends BaseClass> implements BaseDao<B> {

    List<B> list = new ArrayList<>();

    public InMemoryDao() {
        System.out.println("InMemoryDao.InMemoryDao");
    }

    @Override
    public void create(B b) {
        list.add(b);
    }

    @Override
    public void update(B b) {

    }

    @Override
    public void delete(Long id) {
        list.removeIf(b -> b.getId().equals(id));
    }

    @Override
    public B getById(Long id) {
        return list.stream().filter(b -> b.getId().equals(id)).findFirst().get();
    }

    @Override
    public Collection<B> getAll() {
        return list;
    }
}
