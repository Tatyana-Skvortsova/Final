package com.skvortsova.menu;

import com.skvortsova.menu.button.circlebutton.AllCirclesButton;
import com.skvortsova.menu.button.circlebutton.CircleByIdButton;
import com.skvortsova.menu.button.learnerbutton.*;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
    private static boolean exitButton = false;
    private static Map<Integer, MenuItem> menu = new TreeMap<>();

    static {
        menu.put(-1, () -> exitButton = true);
        menu.put(11, new AllLearnerButton());
        menu.put(12, new LearnerByIdButton());
        menu.put(13, new SaveNewLearnerButton());
        menu.put(14, new UpdateLearnerButton());
        menu.put(15, new DeleteLearnerButton());
        menu.put(21, new AllCirclesButton());
        menu.put(22,new CircleByIdButton());
    }
    public void startMenu(){
        Scanner scanner = new Scanner(System.in);
        do{
            printMenuChoices();
            Integer choice = scanner.nextInt();
            if(menu.containsKey(choice)){
                menu.get(choice).run();
            }else{
                System.out.println("Выберите пункт, который есть в меню.");
            }
        } while (!exitButton);
    }

    private void printMenuChoices(){
        System.out.println("-----------");
        System.out.println("Выберите пункт меню : ");
        menu.forEach((k,v) -> System.out.println(k + " : " + v.getTitle()));
    }
}

