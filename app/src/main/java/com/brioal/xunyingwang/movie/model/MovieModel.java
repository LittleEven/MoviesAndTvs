package com.brioal.xunyingwang.movie.model;

import com.brioal.xunyingwang.movie.contract.MovieContract;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/30.
 */

public class MovieModel implements MovieContract.Model {
    private String URL_MOVIES = "http://www.xunyingwang.com/movie";
    @Override
    public void loadMovies(MovieContract.OnMoviesLoadListener loadListener) {
        //解析电影列表界面
        // TODO: 2017/7/30

    }
}
