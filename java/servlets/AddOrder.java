package servlets;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class AddOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddOrder() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        List<CartProduct> cartProducts = (List<CartProduct>) session.getAttribute("cartProducts");
        User user = (User) session.getAttribute("user");
        String address = (String) request.getParameter("address");
        DoAddOrder dao = new DoAddOrder();
        try {
            if (dao.do_AddOrder(cartProducts, user, address)) {
                session.setAttribute("cartProducts", null);
                response.sendRedirect("GetOrder");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}