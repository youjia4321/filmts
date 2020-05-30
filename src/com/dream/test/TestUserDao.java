package com.dream.test;

import com.dream.biz.IUserBiz;
import com.dream.biz.impl.UserBizImpl;
import com.dream.dao.IUserDao;
import com.dream.dao.impl.UserDaoImpl;
import org.junit.Test;

public class TestUserDao {

    IUserDao userDao = new UserDaoImpl();

    IUserBiz userBiz = new UserBizImpl();

    @Test
    public void testProvince() {

        System.out.println(userDao.getProvince());
//        System.out.println(userDao.getCityName(5));

    }

    @Test
    public void testCity() {

        System.out.println(userDao.getCity(1));

    }

}
