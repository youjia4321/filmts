package com.dream.vo;

import java.util.Arrays;

public class Movie implements Comparable<Movie> {

    private Integer id;
    private String name;
    private Double price;
    private String actor;
    private String director;
    private Double score;
    private String imageUrl; // 图片地址
    private String type;
    private Integer tid; // 上映时间id


    public Movie() {}

    public Movie(String name, Double price, String actor, String director, Double score, String type, Integer tid) {
        this.name = name;
        this.price = price;
        this.actor = actor;
        this.director = director;
        this.score = score;
        this.type = type;
        this.tid = tid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", score=" + score +
                ", imageUrl=" + imageUrl +
                ", type='" + type + '\'' +
                ", tid=" + tid +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        if(this.score > o.score) {
            return -1;
        } else if(this.score < o.score) {
            return 1;
        } else {
            if(this.price > o.price) {
                return -1;
            } else if (this.price < o.price){
                return 1;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }
}
