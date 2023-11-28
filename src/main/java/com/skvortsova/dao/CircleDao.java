package com.skvortsova.dao;

import com.skvortsova.DatabaseConnector;
import com.skvortsova.entity.Circle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CircleDao implements CrudDao<Circle> {
    private final Connection connection = DatabaseConnector.getConnection();

    @Override
    public List<Circle> findAll() {
        List<Circle> circles = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from circles");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Circle c = new Circle();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setPrice(rs.getInt(3));

                circles.add(c);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return circles;
    }

    @Override
    public Circle findById(int id) {
        Circle circle = new Circle();
        try{
            PreparedStatement ps = connection.prepareStatement("select * from circles where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                circle.setId(rs.getInt(1));
                circle.setName(rs.getString(2));
                circle.setPrice(rs.getInt(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return circle;
    }

    @Override
    public Circle save(Circle entity) {
        try{
            PreparedStatement ps = connection.prepareStatement(
                    "insert into circles (name, price) values (?,?)");

            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getPrice());

            ps.executeUpdate();

            PreparedStatement pst = connection.prepareStatement("select id from circles where name = ? AND price = ?");
            pst.setString(1, entity.getName());
            pst.setInt(2, entity.getPrice());

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
    public void update(Circle entity) {
        try{
            PreparedStatement ps = connection.prepareStatement(
                    "update circles set name = ?, price = ? where id = ?");
            ps.setString(1, entity.getName());
            ps.setInt(2,entity.getPrice());
            ps.setInt(3, entity.getId());

            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Circle entity) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from circles where id = ?");
            ps.setInt(1, entity.getId());
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
