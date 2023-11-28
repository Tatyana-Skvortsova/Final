package com.skvortsova.menu.button.learnerbutton;

import com.skvortsova.dao.LearnerDao;
import com.skvortsova.menu.MenuItem;

import java.util.Scanner;

public class LearnerByIdButton implements MenuItem {
    private final LearnerDao learnerDao = new LearnerDao();
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id ученика");
        int id = scanner.nextInt();

        System.out.println(learnerDao.findById(id));
    }

    @Override
    public String getTitle() {
        return "Найти ученика по id";
    }
}
