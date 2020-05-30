package com.dream.dao;

import com.dream.vo.City;
import com.dream.vo.Province;
import com.dream.vo.User;

import java.util.List;

public interface IUserDao {

    void add(User user);

    void updateById(Integer id, String name, String password, String sex, String email, Integer provinceId, Integer cityId, String avatar);

    User getUserById(Integer id);

    User getUserByName(String name);

    User getUserByNameAndPassword(String name, String password);

    List<Province> getProvince();

    List<City> getCity(Integer provinceId);

    String getProvinceName(Integer provinceId);

    String getCityName(Integer cityId);

    String getRoleName(Integer roleId);

}
