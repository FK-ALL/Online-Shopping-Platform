package servlets;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;

public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login_Name = request.getParameter("login_Name");
        String login_Password = request.getParameter("login_Password");
        HttpSession session = request.getSession();
        if (login_Password.length() < 8) {
            session.setAttribute("registerResult", "密码不能少于8位！");
            response.sendRedirect("register.jsp");
        }

        else {
            DoRegister reg = new DoRegister();
            try {
                if (reg.do_CheckLoginName(login_Name)) {
                    if (reg.do_Register(login_Name, login_Password)) {
                        request.setAttribute("login_Name", login_Name);
                        request.setAttribute("login_Password", login_Password);
                        request.getRequestDispatcher("Login").forward(request, response);
                    } else {
                        session.setAttribute("registerResult", "注册失败，请重新尝试！");
                        response.sendRedirect("register.jsp");
                    }
                } else {
                    session.setAttribute("registerResult", "用户名已存在！");
                    response.sendRedirect("register.jsp");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
