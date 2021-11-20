package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;

public class DeleteAddress extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteAddress() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_address_id = Integer.parseInt((String) request.getParameter("user_address_id"));
        DoDeleteAddress dda = new DoDeleteAddress();
        PrintWriter out = response.getWriter();

        try {
            if (dda.do_DeleteAddress(user_address_id)) {
                response.sendRedirect("GetAddress");
            } else
                out.println("222");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}