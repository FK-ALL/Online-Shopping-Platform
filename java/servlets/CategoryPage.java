package servlets;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;

public class CategoryPage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CategoryPage() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        DoGetCategoryProducts dgcp = new DoGetCategoryProducts();
        try {
            List<Integer> pids = (List<Integer>) dgcp.do_GetCategoryProducts(categoryId);
            request.setAttribute("pids", pids);
            request.setAttribute("categoryId", categoryId);
            request.getRequestDispatcher("/categoryPage.jsp").forward(request, response);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}