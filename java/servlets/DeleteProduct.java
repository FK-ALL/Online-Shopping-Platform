package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;

public class DeleteProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteProduct() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int product_Id = Integer.parseInt(request.getParameter("product_Id"));
        DoDeleteProduct ddp = new DoDeleteProduct();
        PrintWriter out = response.getWriter();
        try {
            if (ddp.do_DeleteProduct(product_Id)) {
                out.println("成功");
            } else
                out.println("失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
