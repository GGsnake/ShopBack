package com.zyqhw.springboot.domain;

import java.io.Serializable;

public class Fake implements Serializable {
    private String name;
    private String address;

    private Integer id;

    @Override
    public String toString() {
        return "Fake{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
