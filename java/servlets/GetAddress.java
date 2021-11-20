package servlets;

import java.io.*;
import java.sql.*;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class GetAddress extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetAddress() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        DoGetAddress dga = new DoGetAddress();
        /* PrintWriter out = response.getWriter(); */

        try {
            if (dga.do_GetAddress(user.getUser_Id()) != null) {
                Map<String, Map<Integer, String>> map = dga.do_GetAddress(user.getUser_Id());
                session.setAttribute("map", map);

            } else {
                session.setAttribute("map", null);
            }
            response.sendRedirect("personalData.jsp");
            /* out.println("无"); */

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
