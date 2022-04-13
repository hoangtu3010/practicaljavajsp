package com.example.practicaljavajsp.controller.product;

import com.example.practicaljavajsp.entity.Product;
import com.example.practicaljavajsp.model.GenericModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetListProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericModel<Product> model  = new GenericModel<>(Product.class);

        List<Product> result = model.getAll();

        if (result.size() == 0){
            Product product1 = new Product("Product 1", 100, 123, "This is detail product 1");
            Product product2 = new Product("Product 2", 200, 93, "This is detail product 2");
            Product product3 = new Product("Product 3", 150, 12, "This is detail product 3");
            Product product4 = new Product("Product 4", 300, 121, "This is detail product 4");
            Product product5 = new Product("Product 5", 180, 200, "This is detail product 5");

            model.save(product1);
            model.save(product2);
            model.save(product3);
            model.save(product4);
            model.save(product5);
        }

        req.setAttribute("listProducts", result);

        req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
    }
}
