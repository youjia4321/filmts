package com.dream.test;

import com.dream.biz.IMovieBiz;
import com.dream.biz.impl.MovieBizImpl;
import com.dream.dao.IMovieDao;
import com.dream.dao.impl.MovieDaoImpl;
import com.dream.vo.Movie;
import org.junit.Test;

import java.util.List;

public class TestMovies {

    public IMovieDao movieDao = new MovieDaoImpl();
    public IMovieBiz movieBiz = new MovieBizImpl();

    @Test
    public void testGetMovie(){

        List<Movie> movies = movieDao.getMovieList(0, 2);

        for (Movie movie: movies) {
            System.out.println(movie);
        }
    }

    @Test
    public void getMovieCount() {

        System.out.println(movieBiz.getAllPage(2));
    }

}
