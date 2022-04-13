package com.example.practicaljavajsp.controller.account;

import com.example.practicaljavajsp.entity.Product;
import com.example.practicaljavajsp.entity.User;
import com.example.practicaljavajsp.model.GenericModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericModel<User> accountModel = new GenericModel<>(User.class);

        List<User> result = accountModel.getAll();

        if (result.size() == 0){
            User user = new User("admin", "abc123@");

            accountModel.save(user);
        }

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericModel<User> accountModel = new GenericModel<>(User.class);

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        User account = accountModel.findByUserName(userName);

        if (account == null){
            resp.getWriter().println("Invalid information!");
            return;
        }

        if (password.equals(account.getPassword())){
            HttpSession session = req.getSession();
            session.setAttribute("currentAccount", account);

            resp.sendRedirect("/products");
        }else {
            resp.getWriter().println("Login fail!");
        }
    }
}
