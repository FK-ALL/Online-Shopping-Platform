package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;

public class UpdateCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateCart() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_Id = Integer.parseInt(request.getParameter("user_Id"));
        int product_Id = Integer.parseInt(request.getParameter("product_Id"));
        int purchaseNumber = Integer.parseInt(request.getParameter("purchaseNumber"));
        PrintWriter out = response.getWriter();
        DoUpdateCart duc = new DoUpdateCart();
        try {
            if (duc.do_UpdateCart(user_Id, product_Id, purchaseNumber)) {

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_Id = Integer.parseInt(request.getParameter("user_Id"));
        int product_Id = Integer.parseInt(request.getParameter("product_Id"));
        DoUpdateCart duc = new DoUpdateCart();
        PrintWriter out = response.getWriter();
        try {
            if (duc.do_DeleteCart(user_Id, product_Id)) {
                response.sendRedirect("GetCart");
            } else
                out.println("111");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}