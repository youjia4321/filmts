package com.dream.servlet;

import com.alibaba.fastjson.JSON;
import com.dream.biz.IMovieBiz;
import com.dream.biz.impl.MovieBizImpl;
import com.dream.vo.Movie;
import com.dream.vo.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "MovieServlet")
public class MovieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private IMovieBiz movieBiz = new MovieBizImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("action");

        if (action.equals("getMovieList")) {

            doGetMovieList(request, response);

        } else if (action.equals("getMovieJson")) {

            int currentPage = Integer.parseInt(request.getParameter("currentPage"));

            int num = Integer.parseInt(request.getParameter("num"));

            List<Movie> movies = movieBiz.getMovieList(currentPage, num);

            HashMap<String, Object> map = new HashMap<>();

            map.put("code", 0);
            map.put("msg", "success");
            map.put("count", movieBiz.getCount());
            map.put("data", movies);

            String jsonStr = JSON.toJSONString(map);

            response.getWriter().println(jsonStr);

        }
    }

    private void doGetMovieList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));

        int num = 10;

        List<Movie> movies = movieBiz.getMovieList(currentPage, num);

        int allPage = movieBiz.getAllPage(num);

        Page page = new Page("MovieServlet?action=getMovieList&currentPage=", currentPage, allPage, num);

        request.setAttribute("movies", movies);

        request.setAttribute("page", page);

        request.getRequestDispatcher("movieList.jsp").forward(request, response);
    }
}
