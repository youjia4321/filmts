package com.dream.dao.impl;

import com.dream.dao.IUserDao;
import com.dream.utils.DBUtil;
import com.dream.vo.City;
import com.dream.vo.Province;
import com.dream.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    @Override
    public void add(User user) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "insert into users(name, email, password, avatar, sex, province_id, city_id, rid)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getAvatar());
            ps.setString(5, user.getSex());
            ps.setInt(6, user.getProvinceId());
            ps.setInt(7, user.getCityId());
            ps.setInt(8, user.getRoleId());

            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }
    }

    @Override
    public void updateById(Integer id, String name, String password, String sex, String email, Integer provinceId,
                           Integer cityId, String avatar) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "update users set name=?, password=?, email=?, sex=?, avatar=?, province_id=?, " +
                    "city_id=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, sex);
            ps.setString(5, avatar);
            ps.setInt(6, provinceId);
            ps.setInt(7, cityId);
            ps.setInt(8, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }

    }

    @Override
    public User getUserById(Integer id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        User user = new User();

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from users where id= ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if(rs.next()) {

                user.setId(id);
                user.setName(rs.getString("name"));
                user.setRoleId(rs.getInt("rid"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setSex(rs.getString("sex"));
                user.setAvatar(rs.getString("avatar"));
                user.setProvinceId(rs.getInt("province_id"));
                user.setCityId(rs.getInt("city_id"));


                return user;

            }

        } catch (Exception e) {
            System.out.println("id 查询学生出错");
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return null;
    }

    @Override
    public User getUserByName(String name) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        User user = new User();

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from users where name= ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);

            rs = ps.executeQuery();

            if(rs.next()) {

                user.setId(rs.getInt("uid"));
                user.setName(rs.getString("name"));
                user.setRoleId(rs.getInt("rid"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setSex(rs.getString("sex"));
                user.setAvatar(rs.getString("avatar"));
                user.setProvinceId(rs.getInt("province_id"));
                user.setCityId(rs.getInt("city_id"));


                return user;

            }

        } catch (Exception e) {
            System.out.println("name 查询学生出错");
        } finally {
            DBUtil.close(conn, ps, rs);
        }


        return null;
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        User user = new User();

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from users where name=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if(rs.next()) {
                user.setId(rs.getInt("uid"));
                user.setName(rs.getString("name"));
                user.setRoleId(rs.getInt("rid"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setSex(rs.getString("sex"));
                user.setAvatar(rs.getString("avatar"));
                user.setProvinceId(rs.getInt("province_id"));
                user.setCityId(rs.getInt("city_id"));


                return user;

            }

        } catch (Exception e) {
            System.out.println("id 查询学生出错");
        } finally {
            DBUtil.close(conn, ps, rs);
        }


        return null;
    }

    @Override
    public List<Province> getProvince() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Province> list = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();
            String sql = "select id, name, type from tb_city where type = 1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                list.add(new Province(rs.getInt("id"), rs.getString("name"), rs.getInt("type")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return list;
    }

    @Override
    public List<City> getCity(Integer provinceId) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<City> list = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from tb_city where type = 2 and ofprovince = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, provinceId);
            rs = ps.executeQuery();

            while(rs.next()) {
                list.add(new City(rs.getInt("id"), rs.getString("name"), rs.getInt("type"), provinceId));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取市列表出错");
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return list;
    }

    @Override
    public String getProvinceName(Integer provinceId) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select name from tb_city where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, provinceId);
            rs = ps.executeQuery();

            if(rs.next()) {
                return rs.getString("name");
            }

        } catch (Exception e) {
            System.out.println("获取省名出错");
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return null;
    }

    @Override
    public String getCityName(Integer cityId) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select name from tb_city where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cityId);
            rs = ps.executeQuery();

            if(rs.next()) {
                return rs.getString("name");
            }

        } catch (Exception e) {
            System.out.println("获取市名出错");
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return null;

    }

    @Override
    public String getRoleName(Integer roleId) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select rname from role where rid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();

            if(rs.next()) {
                return rs.getString("rname");
            }

        } catch (Exception e) {
            System.out.println("获取角色名出错");
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return null;
    }
}
