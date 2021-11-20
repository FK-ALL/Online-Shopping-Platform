package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login_Name = request.getParameter("login_Name");
        String login_Password = request.getParameter("login_Password");

        // PrintWriter out = response.getWriter();// 打印

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if (login_Name.equals("") || login_Password.equals("")) {
            backToLogin(request, response, "账号或密码为空！");

            // out.println("null");
        }

        else {
            DoLogin dLog = new DoLogin();
            try {
                User user = dLog.do_Login(login_Name, login_Password);
                if (user == null) {
                    backToLogin(request, response, "账号或密码错误！");
                }
                // out.println("wrong");
                else {
                    // out.println("ok");

                    if (user.getUser_Status() > 0) {
                        backToLogin(request, response, "您的账号已被禁用，剩余：" + user.getUser_Status() + " 天！");

                    }
                    // out.println("no");
                    else {
                        session.setAttribute("user", user);
                        response.sendRedirect("index.jsp");

                        // out.println(user.getUser_Id());
                        // out.println(user.getLogin_Name());

                    }

                }

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void backToLogin(HttpServletRequest request, HttpServletResponse response, String s)
            throws ServletException, IOException {
        request.setAttribute("loginResult", s);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
