package com.example.vanquangphong_lab1.controllers;

import com.example.vanquangphong_lab1.models.Account;
import com.example.vanquangphong_lab1.respository.AccountRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/log-in")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        AccountRepository accountRepository = new AccountRepository();
        if(accountRepository.checkLogIn(req.getParameter("account_id"), req.getParameter("password"))){
            List<Account> accounts = accountRepository.getAll();;
            req.setAttribute("accounts", accounts);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("success.jsp");
            requestDispatcher.forward(req, res);
        }
    }
}
