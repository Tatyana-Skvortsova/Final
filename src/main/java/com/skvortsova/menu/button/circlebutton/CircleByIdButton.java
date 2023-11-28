package com.skvortsova.menu.button.circlebutton;

import com.skvortsova.dao.CircleDao;
import com.skvortsova.menu.MenuItem;

import java.util.Scanner;

public class CircleByIdButton implements MenuItem {
    private final CircleDao circleDao = new CircleDao();
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id кружка");
        int id = scanner.nextInt();

        System.out.println(circleDao.findById(id));
    }

    @Override
    public String getTitle() {
        return "Найти кружок по id";
    }
}
