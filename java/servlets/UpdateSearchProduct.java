package servlets;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import beans.Product;
import dao.*;

public class UpdateSearchProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateSearchProduct() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        DoUpdateSearchProduct dusp = new DoUpdateSearchProduct();
        try {
            List<Product> products = (List<Product>) dusp.do_UpdateSearchProduct(productName);
            request.setAttribute("products", products);

            request.getRequestDispatcher("/administratorUpdateProduct.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}