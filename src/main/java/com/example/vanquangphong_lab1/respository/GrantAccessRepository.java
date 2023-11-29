package com.example.vanquangphong_lab1.respository;

import com.example.vanquangphong_lab1.db.Connectiondb;
import com.example.vanquangphong_lab1.models.Account;
import com.example.vanquangphong_lab1.models.Grant_Access;
import com.example.vanquangphong_lab1.models.Isgrant;
import com.example.vanquangphong_lab1.models.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrantAccessRepository {
    private static Connection connection = Connectiondb.createConnection();
    public void create(Grant_Access grantAccess){
        String sql = "INSERT INTO account VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, String.valueOf(grantAccess.getRole()));
            preparedStatement.setString(2, String.valueOf(grantAccess.getAccout_id()));
            preparedStatement.setString(3, String.valueOf(grantAccess.getIs_grant()));
            preparedStatement.setString(4, grantAccess.getNote());

            preparedStatement.executeUpdate();

            System.out.println("--correct insert on database");

        } catch(SQLException e) {
            System.out.println("--incorrect insert on database. " + e.getMessage());
        }
    }

    public List<Grant_Access> getAll() {

        String sql = "SELECT * FROM grant_access inner join account on grant_access.account_id = account.account_id" +
                "inner join role on grant_access.role_id = role.role_id";
        List<Grant_Access> grantAccesses = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Account a = new Account();
                Role r = new Role();

                a.setAccount_id(resultSet.getString("account_id"));
                a.setFull_name(resultSet.getString("full_name"));
                a.setPassword(resultSet.getString("password"));
                a.setEmail(resultSet.getString("full_name"));
                a.setFull_name(resultSet.getString("full_name"));
                a.setStatus(resultSet.getInt("status"));

                r.setRole_id(resultSet.getString("role_id"));
                r.setRole_name(resultSet.getString("role_name"));
                r.setDescription(resultSet.getString("description"));
                r.setStatus(Integer.parseInt(resultSet.getString("status")));


            }

            System.out.println("--correct find");
            return grantAccesses;

        } catch (SQLException e) {
            System.out.println("--incorrect find. " + e.getMessage());
            return null;
        }
    }
}
