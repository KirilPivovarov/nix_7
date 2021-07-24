package ua.com.alevel.crud.impl;

import ua.com.alevel.Profile;
import ua.com.alevel.crud.BaseDao;
import ua.com.alevel.crud.config.ObjectImplFactory;

public class ProfileDao {

    BaseDao<Profile> profileInMemoryDao = ObjectImplFactory.getInstance().getImpl(BaseDao.class);
}
