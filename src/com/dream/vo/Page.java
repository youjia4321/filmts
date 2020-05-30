package com.dream.vo;

// 存放分页的数据
public class Page {
    private String url;
    private int currentPage;
    private int allPage;
    private int num;

    public Page(String url, int currentPage, int allPage, int num) {
        super();
        this.url = url;
        this.currentPage = currentPage;
        this.allPage = allPage;
        this.num = num;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getAllPage() {
        return allPage;
    }
    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Page{" +
                "url='" + url + '\'' +
                ", currentPage=" + currentPage +
                ", allPage=" + allPage +
                ", num=" + num +
                '}';
    }
}