package com.skvortsova.dao;

import com.skvortsova.DatabaseConnector;
import com.skvortsova.entity.Circle;
import com.skvortsova.entity.Learner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LearnerDao implements CrudDao<Learner>{

    private final Connection connection = DatabaseConnector.getConnection();

    @Override
    public List<Learner> findAll() {
        List<Learner> learners = new ArrayList<>();

        try{
            PreparedStatement ps = connection.prepareStatement(
                    "select * from learners join circles on circles.id = learners.circle_id");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Learner l = new Learner();
                l.setId(rs.getInt(1));
                l.setLastName(rs.getString(2));
                l.setFirstName(rs.getString(3));
                l.setClassroom(rs.getInt(4));

                Circle circle = new Circle();
                circle.setId(rs.getInt(5));
                circle.setName(rs.getString(7));
                circle.setPrice(rs.getInt(8));

                l.setCircle(circle);
                learners.add(l);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return learners;
    }

    @Override
    public Learner findById(int id) {
        Learner learner = new Learner();
        String sql = "select * from learners join circles on circles.id = learners.circle_id where learners.id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                learner.setId(rs.getInt(1));
                learner.setLastName(rs.getString(2));
                learner.setFirstName(rs.getString(3));
                learner.setClassroom(rs.getInt(4));

                Circle circle = new Circle();
                circle.setId(rs.getInt(5));
                circle.setName(rs.getString(7));
                circle.setPrice(rs.getInt(8));

                learner.setCircle(circle);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return learner;
    }

    @Override
    public Learner save(Learner entity) {
        try{
            PreparedStatement ps = connection.prepareStatement(
                    "insert into learners (last_name, first_name, class, circle_id) values (?,?,?,?)");

            ps.setString(1, entity.getLastName());
            ps.setString(2, entity.getFirstName());
            ps.setInt(3, entity.getClassroom());
            ps.setInt(4, entity.getCircle().getId());

            ps.executeUpdate();

            PreparedStatement pst = connection.prepareStatement("select id from learners where last_name = ? AND first_name = ? AND class = ?");
            pst.setString(1, entity.getLastName());
            pst.setString(2, entity.getFirstName());
            pst.setInt(3, entity.getClassroom());
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                entity.setId(rs.getInt(1));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void update(Learner entity) {
        try{
            PreparedStatement ps = connection.prepareStatement(
                    "update learners set last_name = ?, first_name = ?, class = ?, circle_id = ? where id = ?");
            ps.setString(1, entity.getLastName());
            ps.setString(2, entity.getFirstName());
            ps.setInt(3,entity.getClassroom());
            ps.setInt(4, entity.getCircle().getId());
            ps.setInt(5, entity.getId());

            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Learner entity) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from learners where id = ?");
            ps.setInt(1, entity.getId());
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
