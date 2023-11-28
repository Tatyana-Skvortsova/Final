package com.skvortsova.menu.button.learnerbutton;

import com.skvortsova.dao.LearnerDao;
import com.skvortsova.entity.Circle;
import com.skvortsova.entity.Learner;
import com.skvortsova.menu.MenuItem;

import java.util.Scanner;

public class UpdateLearnerButton implements MenuItem {

    private LearnerDao learnerDao = new LearnerDao();
    @Override
    public void run() {
        Learner l = updateLearner();
        learnerDao.update(l);
    }

    @Override
    public String getTitle() {
        return "Обновить сведения об ученике";
    }

    private Learner updateLearner() {
        Scanner scanner = new Scanner(System.in);
        Learner l = new Learner();
        System.out.println("Введите id ученика, которого хотите обновить");
        l.setId(scanner.nextInt());
        System.out.println("Обновите фамилию ученика");
        String s = scanner.nextLine();
        l.setLastName(scanner.nextLine());
        System.out.println("Обновите имя ученика");
        l.setFirstName(scanner.nextLine());
        System.out.println("Обновите класс");
        l.setClassroom(scanner.nextInt());
        System.out.println("Обновите Id кружка");
        Circle c = new Circle();
        c.setId(scanner.nextInt());
        l.setCircle(c);

        return l;
    }
}
