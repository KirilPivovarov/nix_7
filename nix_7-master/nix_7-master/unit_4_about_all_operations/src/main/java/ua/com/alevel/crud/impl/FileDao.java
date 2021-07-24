package ua.com.alevel.crud.impl;

import ua.com.alevel.BaseClass;
import ua.com.alevel.crud.BaseDao;

import java.util.Collection;

public class FileDao<B extends BaseClass> implements BaseDao<B> {

    public FileDao() {
        System.out.println("FileDao.FileDao");
    }

    @Override
    public void create(B b) {

    }

    @Override
    public void update(B b) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public B getById(Long id) {
        return null;
    }

    @Override
    public Collection<B> getAll() {
        return null;
    }
}
