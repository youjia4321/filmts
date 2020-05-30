package com.dream.dao.impl;

import com.dream.dao.IMovieDao;
import com.dream.utils.DBUtil;
import com.dream.vo.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieDaoImpl implements IMovieDao {

    @Override
    public List<Movie> getMovieList(int offset, int num) {

        List<Movie> movies = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from movies limit ?, ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,offset);
            ps.setInt(2, num);
            rs = ps.executeQuery();

            while(rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("mid"));
                movie.setName(rs.getString("mname"));
                movie.setPrice(rs.getDouble("mprice"));
                movie.setActor(rs.getString("mactor"));
                movie.setDirector(rs.getString("mdirector"));
                movie.setTid(rs.getInt("tid"));
                movie.setType(rs.getString("mtype"));
                movie.setImageUrl(rs.getString("mimage"));
                movie.setScore(rs.getDouble("mscore"));

                movies.add(movie);

                // 排序
                Collections.sort(movies);
            }

        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return movies;
    }

    @Override
    public List<Movie> getMovieList() {

        List<Movie> movies = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from movies";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("mid"));
                movie.setName(rs.getString("mname"));
                movie.setPrice(rs.getDouble("mprice"));
                movie.setActor(rs.getString("mactor"));
                movie.setDirector(rs.getString("mdirector"));
                movie.setTid(rs.getInt("tid"));
                movie.setType(rs.getString("mtype"));
                movie.setImageUrl(rs.getString("mimage"));
                movie.setScore(rs.getDouble("mscore"));

                movies.add(movie);

                // 排序
                Collections.sort(movies);
            }

        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return movies;
    }

    @Override
    public int getCount() {

        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select count(*) from movies";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                count = rs.getInt(1);
            }

        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return count;
    }
}
