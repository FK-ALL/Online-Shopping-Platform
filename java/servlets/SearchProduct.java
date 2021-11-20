package servlets;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;

public class SearchProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SearchProduct() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        DoSearchProduct dsp = new DoSearchProduct();
        try {
            List<Integer> pids = (List<Integer>) dsp.do_SearchProduct(productName);
            request.setAttribute("pids", pids);
            request.setAttribute("productName", productName);
            request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}