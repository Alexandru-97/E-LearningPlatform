package repository;

import config.*;
import model.*;


import java.sql.*;
import java.util.Optional;

public class UserRepository {
    /*
     *   Statement
     *   PreparedStatement
     *   CallableStatement
     *
     * */

    public void addUser(User user) {
        String sql = "insert into employees values (null, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
            statement.setString(1, user.getName());
            statement.setBoolean(2, user.isPremium());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String name){
        String sql = "delete from employees where name = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            statement.setString(1, name);
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}