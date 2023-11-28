package com.skvortsova.entity;

import com.skvortsova.DatabaseConnector;

import java.sql.Connection;

public class Circle {
    private int id;
    private String name;

    private int price;

    public Circle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Кружки {" +
                "id=" + id +
                ", Название кружка: " + name +
                ", Стоимость/мес.:" + price +
                '}';
    }
}
