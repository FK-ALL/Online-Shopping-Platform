package servlets;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class GetCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetCart() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        int user_Id = ((User) session.getAttribute("user")).getUser_Id();
        Map<String, Map<Integer, String>> map = (Map<String, Map<Integer, String>>) session.getAttribute("map");

        try {
            DoGetCart dgc = new DoGetCart();
            List<CartProduct> cartProducts = (List<CartProduct>) dgc.do_GetCart(user_Id);
            if (map == null) {
                DoGetAddress dga = new DoGetAddress();
                map = dga.do_GetAddress(user_Id);
                session.setAttribute("map", map);
            }
            session.setAttribute("cartProducts", cartProducts);
            response.sendRedirect("purchaseCart.jsp");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
