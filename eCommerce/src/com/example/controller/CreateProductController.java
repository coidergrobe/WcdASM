package com.example.controller;

import com.example.entity.Product;
import com.example.entity.LoginBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateProductController")
public class CreateProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Product product = new Product(id, name, description);
        product.setId(id);
        product.setName(name);
        product.setDescription(description);

        boolean status = false;
        try {
            status = product.getInsertProduct();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();

        if(status){
            session.setAttribute("product", product);
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("failed.jsp");
        }

    }
}
