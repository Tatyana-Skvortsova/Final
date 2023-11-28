package com.skvortsova.menu.button.learnerbutton;

import com.skvortsova.dao.LearnerDao;
import com.skvortsova.menu.MenuItem;

public class AllLearnerButton implements MenuItem {
    private final LearnerDao learnerDao = new LearnerDao();
    @Override
    public void run() {
        System.out.println("Список всех учеников : ");
        learnerDao.findAll().forEach(System.out::println);
    }

    @Override
    public String getTitle() {
        return "Показать всех учеников";
    }
}
