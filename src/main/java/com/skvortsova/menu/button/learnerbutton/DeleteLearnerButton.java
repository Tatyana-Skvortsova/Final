package com.skvortsova.menu.button.learnerbutton;

import com.skvortsova.dao.LearnerDao;
import com.skvortsova.entity.Learner;
import com.skvortsova.menu.MenuItem;

import java.util.EmptyStackException;
import java.util.Scanner;

public class DeleteLearnerButton implements MenuItem {
    private final LearnerDao learnerDao = new LearnerDao();
    @Override
    public void run() {
        System.out.println("Введите id ученика");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Learner l = new Learner();
        l.setId(id);
        learnerDao.delete(l);

    }

    @Override
    public String getTitle() {
        return "Удалить ученика из списка";
    }
}
