package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class Change extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Change() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = (String) request.getParameter("table");
        String changeAttribute = (String) request.getParameter("changeAttribute");
        String changeValue = (String) request.getParameter("changeValue");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        PrintWriter out = response.getWriter();
        out.println(table);
        out.println(changeAttribute);
        out.println(changeValue);

        User user = (User) session.getAttribute("user");

        DoChange dochg = new DoChange();
        try {
            if (dochg.do_Change(table, changeAttribute, changeValue, user.getUser_Id())) {
                user.update(changeAttribute, changeValue);
                response.sendRedirect("personalData.jsp");
            } else {
                out.println("错误");// 到时候写错误页面
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
