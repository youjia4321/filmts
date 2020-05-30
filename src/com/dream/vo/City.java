package com.dream.vo;

public class City {

    private Integer id;
    private String name;
    private Integer type;
    private Integer ofProvince;

    public City() {}

    public City(Integer id, String name, Integer type, Integer ofProvince) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.ofProvince = ofProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOfProvince() {
        return ofProvince;
    }

    public void setOfProvince(Integer ofProvince) {
        this.ofProvince = ofProvince;
    }

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", type=" + type + ", ofProvince=" + ofProvince + "]";
    }

}
