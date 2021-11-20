package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;

public class CompleteOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CompleteOrder() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int order_Id = Integer.parseInt(request.getParameter("order_Id"));
        DoUpdateOrder duo = new DoUpdateOrder();
        try {
            if (duo.do_CompleteOrder(order_Id)) {
                response.sendRedirect("GetOrder");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
