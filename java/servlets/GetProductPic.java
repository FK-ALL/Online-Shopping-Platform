package servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class GetProductPic extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetProductPic() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int product_Id = Integer.parseInt(request.getParameter("productId"));

        PrintWriter out = response.getWriter();
        DoGetProduct dgp = new DoGetProduct();

        try {

            Product product = dgp.do_GetProduct(product_Id);

            if (product != null) {

                request.setAttribute("product", product);
                request.getRequestDispatcher("/productPic.jsp").forward(request, response);

            } else
                out.println("null");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}