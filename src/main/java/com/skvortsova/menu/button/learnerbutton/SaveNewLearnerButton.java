package com.skvortsova.menu.button.learnerbutton;

import com.skvortsova.dao.LearnerDao;
import com.skvortsova.entity.Circle;
import com.skvortsova.entity.Learner;
import com.skvortsova.menu.MenuItem;

import java.util.Scanner;

public class SaveNewLearnerButton implements MenuItem {
    private final LearnerDao learnerDao = new LearnerDao();

    @Override
    public void run() {
        Learner l = inputNewLearner();
        System.out.println(learnerDao.save(l));

    }

    @Override
    public String getTitle() {
        return "Добавить нового ученика";
    }

    private Learner inputNewLearner() {
        Scanner scanner = new Scanner(System.in);
        Learner l = new Learner();
        System.out.println("Введите фамилию ученика");
        l.setLastName(scanner.nextLine());
        System.out.println("Введите имя ученика");
        l.setFirstName(scanner.nextLine());
        System.out.println("Введите класс");
        l.setClassroom(scanner.nextInt());
        System.out.println("Введите Id кружка");
        Circle c = new Circle();
        c.setId(scanner.nextInt());
        l.setCircle(c);

        return l;
    }
}
