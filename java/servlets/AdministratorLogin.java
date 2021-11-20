package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class AdministratorLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdministratorLogin() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String administrator_RealName = request.getParameter("administrator_RealName");
        String administrator_Password = request.getParameter("administrator_Password");
        String administrator_IDCode = request.getParameter("administrator_IDCode");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        PrintWriter out = response.getWriter();

        DoAdministratorLogin dal = new DoAdministratorLogin();
        try {
            Administrator administrator = dal.do_AdministratorLogin(administrator_RealName, administrator_Password,
                    administrator_IDCode);
            if (administrator != null) {
                session.setAttribute("administrator", administrator);
                response.sendRedirect("administratorPage.jsp");
            } else {
                out.print("错误！");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
