package servlets;

import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class GetOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetOrder() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int user_Id = user.getUser_Id();

        try {
            DoGetOrder dgo = new DoGetOrder();
            List<Order> orders = dgo.do_GetOrder(user_Id);

            session.setAttribute("orders", orders);
            response.sendRedirect("order.jsp");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
