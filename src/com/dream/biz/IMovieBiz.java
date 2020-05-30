package com.dream.biz;

import com.dream.vo.Movie;

import java.util.List;

public interface IMovieBiz {

    List<Movie> getMovieList(int page, int num);

    List<Movie> getMovieList();

    int getAllPage(int num);

    int getCount();

}
