package com.dream.vo;

public class Province {

    private Integer id;
    private String name;
    private Integer type;

    public Province() {}


    public Province(Integer id, String name, Integer type) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
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


    @Override
    public String toString() {
        return "Province [id=" + id + ", name=" + name + ", type=" + type + "]";
    }

}
