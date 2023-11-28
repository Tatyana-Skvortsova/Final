package com.skvortsova;


import com.skvortsova.dao.CircleDao;
import com.skvortsova.dao.LearnerDao;
import com.skvortsova.entity.Circle;
import com.skvortsova.entity.Learner;
import com.skvortsova.menu.Menu;

import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class App{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        new Menu().startMenu();


//        Connection connection = DatabaseConnector.getConnection();
//        System.out.println("Connection is succeeded");

//        System.out.println("Список кружков");
//        CircleDao circleDao = new CircleDao();
//        List<Circle> circleList = circleDao.findAll();
//        circleList.forEach(System.out::println);
//        System.out.println("---------------------");
//
//        System.out.println(circleDao.findById(1));
//        System.out.println("---------------------");
//
//        Circle c = new Circle();
//        c.setName("Вокал");
//        c.setPrice(1500);
//        c = circleDao.save(c);
//
//        System.out.println("---------------------");
//        circleList = circleDao.findAll();
//        circleList.forEach(System.out::println);
//        System.out.println("---------------------");
//
//        c.setPrice(1200);
//        circleDao.update(c);
//
//        circleList = circleDao.findAll();
//        circleList.forEach(System.out::println);
//        System.out.println("---------------------");
//
//        c.setId(12);
//        circleDao.delete(c);
//
//        System.out.println("---------------------");
//        circleList = circleDao.findAll();
//        circleList.forEach(System.out::println);
//        System.out.println("---------------------");

//
//        l.setId(12);
//        learnerDao.delete(l);
//

//        System.out.println("---------------------");
//        learnerList = learnerDao.findAll();
//        learnerList.forEach(System.out::println);
//
//        System.out.println("Список учеников");
//        LearnerDao learnerDao = new LearnerDao();
//        List<Learner> learnerList = learnerDao.findAll();
//
//        learnerList.forEach(System.out::println);
//        System.out.println("---------------------");
//
//        System.out.println(learnerDao.findById(2));
//
//        Learner l = new Learner();
//        l.setLastName("Попов");
//        l.setFirstName("Александр");
//        l.setClassroom(1);
//        l = learnerDao.save(l);
//
//
//        System.out.println("---------------------");
//        learnerList = learnerDao.findAll();
//        learnerList.forEach(System.out::println);
//
//        l.setClassroom(9);
//        learnerDao.update(l);
//
//        l.setId(12);
//        learnerDao.delete(l);
//
//        System.out.println("---------------------");
//        learnerList = learnerDao.findAll();
//        learnerList.forEach(System.out::println);
    }
}
