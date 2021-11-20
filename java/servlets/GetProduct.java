package servlets;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class GetProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetProduct() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int product_Id = Integer.parseInt(request.getParameter("productId"));

        DoGetProduct dgp = new DoGetProduct();
        DoGetProductComments dgpc = new DoGetProductComments();
        try {

            Product product = dgp.do_GetProduct(product_Id);
            List<Comment> comments = dgpc.do_GetProductComments(product_Id);

            if (product != null) {

                request.setAttribute("product", product);
                if (comments != null)
                    request.setAttribute("comments", comments);
                request.getRequestDispatcher("/productPage.jsp").forward(request, response);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response, int product_Id, int order_Id)
            throws ServletException, IOException {

        DoGetProduct dgp = new DoGetProduct();
        DoGetProductComments dgpc = new DoGetProductComments();
        try {

            Product product = dgp.do_GetProduct(product_Id);
            List<Comment> comments = dgpc.do_GetProductComments(product_Id);

            if (product != null) {

                request.setAttribute("product", product);
                String _orderId = order_Id + "";
                request.setAttribute("order_Id", _orderId);
                if (comments != null)
                    request.setAttribute("comments", comments);
                request.getRequestDispatcher("/productPage.jsp").forward(request, response);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int product_Id = Integer.parseInt(request.getParameter("product_Id"));
        int order_Id = Integer.parseInt(request.getParameter("order_Id"));

        doGet(request, response, product_Id, order_Id);

    }
}