package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class SetAddress extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SetAddress() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        PrintWriter out = response.getWriter();

        String newProvince = (String) request.getParameter("newProvince");
        String newCity = (String) request.getParameter("newCity");
        String newDistrict = (String) request.getParameter("newDistrict");
        String newAddress = (String) request.getParameter("newAddress");
        if (newProvince.isEmpty() || newCity.isEmpty() || newDistrict.isEmpty() || newAddress.isEmpty()) {
            response.sendRedirect("personalData.jsp");
        }

        else {
            DoSetAddress dsa = new DoSetAddress();

            try {
                if (dsa.do_SetAddress(user.getUser_Id(), newProvince, newCity, newDistrict, newAddress)) {

                    response.sendRedirect("GetAddress");
                } else
                    out.println("222");

            } catch (SQLException e) {

                e.printStackTrace();
            }

        }
    }
}