package com.dream.dao;

import com.dream.vo.Movie;

import java.util.List;

public interface IMovieDao {

    List<Movie> getMovieList(int page, int num);

    List<Movie> getMovieList();

    int getCount();

}
