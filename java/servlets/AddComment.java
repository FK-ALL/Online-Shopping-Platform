package servlets;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class AddComment extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddComment() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int product_Id = Integer.parseInt(request.getParameter("product_Id"));
        int user_Id = Integer.parseInt(request.getParameter("user_Id"));
        String login_Name = (String) request.getParameter("login_Name");
        String newComment = (String) request.getParameter("newComment");
        DoAddComment dac = new DoAddComment();
        try {
            if (dac.do_AddComment(product_Id, user_Id, login_Name, newComment)) {
                response.sendRedirect("GetProduct?productId=" + product_Id);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
