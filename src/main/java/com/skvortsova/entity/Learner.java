package com.skvortsova.entity;

public class Learner {

    private int id;
    private String lastName;
    private String firstName;
    private int classroom;
    private Circle circle;

    public Learner() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    @Override
    public String toString() {
        return "Ученики{" +
                "id=" + id +
                ", Фамилия: " + lastName +
                ", Имя: " + firstName +
                ", Класс: " + classroom +
                ", Кружок: " + circle +
                '}';
    }
}
