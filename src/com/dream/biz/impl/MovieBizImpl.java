package com.dream.biz.impl;

import com.dream.biz.IMovieBiz;
import com.dream.dao.IMovieDao;
import com.dream.dao.impl.MovieDaoImpl;
import com.dream.vo.Movie;

import java.util.List;

public class MovieBizImpl implements IMovieBiz {

    private IMovieDao movieDao = new MovieDaoImpl();

    @Override
    public List<Movie> getMovieList(int page, int num) {
        return movieDao.getMovieList((page-1)*num, num);
    }

    @Override
    public List<Movie> getMovieList() {
        return movieDao.getMovieList();
    }

    @Override
    public int getAllPage(int num) {
        return movieDao.getCount()/num == 0 ? movieDao.getCount()/num + 1 : movieDao.getCount()/num;
    }

    @Override
    public int getCount() {
        return movieDao.getCount();
    }
}
