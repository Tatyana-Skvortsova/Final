package com.skvortsova.menu.button.circlebutton;

import com.skvortsova.dao.CircleDao;
import com.skvortsova.menu.MenuItem;

public class AllCirclesButton implements MenuItem {

    private CircleDao circleDao = new CircleDao();
    @Override
    public void run() {
        System.out.println("Список всех кружков");
        circleDao.findAll().forEach(System.out::println);
    }

    @Override
    public String getTitle() {
        return "Показать все кружки";
    }
}
