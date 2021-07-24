package ua.com.alevel.crud.impl;

import ua.com.alevel.User;
import ua.com.alevel.crud.BaseDao;
import ua.com.alevel.crud.config.ObjectImplFactory;

public class UserDao {

    private BaseDao<User> userInMemoryDao = ObjectImplFactory.getInstance().getImpl(BaseDao.class);

    public void test() {

    }
}
