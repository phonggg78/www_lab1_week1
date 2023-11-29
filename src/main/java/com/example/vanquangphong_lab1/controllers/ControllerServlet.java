package com.example.vanquangphong_lab1.controllers;

import com.example.vanquangphong_lab1.controllers.ControllerServlet;
import com.example.vanquangphong_lab1.models.Account;
import com.example.vanquangphong_lab1.respository.AccountRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/CreateGetAllAccount")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       AccountRepository accountRepository = new AccountRepository();
       Account account = new Account();
        account.setAccount_id(req.getParameter("id"));
        account.setFull_name(req.getParameter("fullName"));
        account.setPassword(req.getParameter("password"));
        account.setEmail(req.getParameter("email"));
        account.setPhone(req.getParameter("phone"));
        account.setStatus(Integer.parseInt(req.getParameter("status")));
        accountRepository.createAccount(account);
    }

}
