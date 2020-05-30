package com.dream.biz.impl;

import com.dream.biz.IUserBiz;
import com.dream.dao.IUserDao;
import com.dream.dao.impl.UserDaoImpl;
import com.dream.vo.City;
import com.dream.vo.Province;
import com.dream.vo.User;

import java.util.List;

public class UserBizImpl implements IUserBiz {

    private IUserDao userDao = new UserDaoImpl();

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void updateById(Integer id, String name, String password, String sex, String email, String provinceId, String cityId, String avatar) {
        userDao.updateById(id, name, password, sex, email, Integer.parseInt(provinceId), Integer.parseInt(cityId), avatar);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) {
        return userDao.getUserByNameAndPassword(name, password);
    }

    @Override
    public User isLogin(String name, String password) {

        User user = userDao.getUserByNameAndPassword(name, password);

        if(user != null) {

            return user;
        }
        return null;
    }

    @Override
    public boolean isRegister(String name) {

        User user = userDao.getUserByName(name);

        if(user== null) {

            return true;
        }

        return false;
    }

    @Override
    public List<Province> getProvince() {
        return userDao.getProvince();
    }

    @Override
    public List<City> getCity(Integer provinceId) {
        return userDao.getCity(provinceId);
    }

    @Override
    public String getProvinceName(Integer provinceId) {
        return userDao.getProvinceName(provinceId);
    }

    @Override
    public String getCityName(Integer cityId) {
        return userDao.getCityName(cityId);
    }

    @Override
    public String getRoleName(Integer roleId) {
        return userDao.getRoleName(roleId);
    }
}
