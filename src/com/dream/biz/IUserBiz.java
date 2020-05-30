package com.dream.biz;

import com.dream.vo.City;
import com.dream.vo.Province;
import com.dream.vo.User;

import java.util.List;

public interface IUserBiz {

    void add(User user);

    void updateById(Integer id, String name, String password, String sex, String email, String provinceId, String cityId, String avatar);

    User getUserById(Integer id);

    User getUserByName(String name);

    User getUserByNameAndPassword(String name, String password);

    User isLogin(String name, String password);

    boolean isRegister(String name);

    List<Province> getProvince();

    List<City> getCity(Integer provinceId);

    String getProvinceName(Integer provinceId);

    String getCityName(Integer cityId);

    String getRoleName(Integer roleId);
}
