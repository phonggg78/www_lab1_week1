package com.example.vanquangphong_lab1.respository;

import com.example.vanquangphong_lab1.db.Connectiondb;
import com.example.vanquangphong_lab1.models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
   private static Connection connection = Connectiondb.createConnection();
    public void createAccount(Account account){
        String sql = "INSERT INTO account  VALUES (?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getAccount_id());
            preparedStatement.setString(2, account.getFull_name());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5,account.getPhone());
            preparedStatement.setInt(6,account.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean login(String user, String password) throws Exception{
        String sql = "select * from account where account_id = ? and password = ?";
       try{
           PreparedStatement preparedStatement  = connection.prepareStatement(sql);
           preparedStatement.setString(1, user);
           preparedStatement.setString(2, password);
           ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
    public boolean insertAccount(Account account) throws Exception {
        String sql = "insert into account values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, account.getAccount_id());
        ps.setString(2, account.getFull_name());
        ps.setString(3, account.getPassword());
        ps.setString(4, account.getEmail());
        ps.setString(5, account.getPhone());
        ps.setInt(6, (account.getStatus()));
        return ps.executeUpdate()>0;
    }
    public boolean deleteAccount(String id) throws Exception{
        String sql = "delete from account where account_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);
        return ps.executeUpdate()>0;
    }
    public Account getById(String id) throws Exception{
        String sql = "select * from account where account_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Account account;
        if(rs.next()){
            account = new Account(rs.getString(1),rs.getString(2),rs.getString(3)
                    ,rs.getString(4),rs.getString(5),rs.getInt(6));
            return account;
        }
        return null;
    }
    public List<Account> getAll(){
        String  sql = "SELECT * FROM account";
        List<Account> acc = new ArrayList<Account>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Account a = new Account();

                a.setAccount_id(resultSet.getString("account_id"));
                a.setFull_name(resultSet.getString("full_name"));
                a.setPassword(resultSet.getString("password"));
                a.setEmail(resultSet.getString("email"));
                a.setPhone(resultSet.getString("phone"));
                a.setStatus(resultSet.getInt("status"));

                acc.add(a);
            }

            System.out.println("--correct find");
            return acc;

        } catch (SQLException e) {
            System.out.println("--incorrect find. " + e.getMessage());
            return null;
        }
    }
    public boolean checkLogIn(String id, String pw){
        String sql = "select * from account where account_id = ? and password = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pw);

            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("--true");

            return rs.next();

        } catch(SQLException e) {
            System.out.println("--false " + e.getMessage());
        }
        return false;
    }
}
