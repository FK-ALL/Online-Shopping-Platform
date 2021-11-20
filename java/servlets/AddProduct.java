package servlets;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class AddProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddProduct() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        String product_Core = (String) request.getParameter("product_Core");
        String product_Name = (String) request.getParameter("product_Name");
        String drug_Name = (String) request.getParameter("drug_Name");
        String GYZZ = (String) request.getParameter("GYZZ");
        int brand_Id = Integer.parseInt(request.getParameter("brand_Id"));
        int first_CategoryId = Integer.parseInt(request.getParameter("first_CategoryId"));
        int second_CategoryId = Integer.parseInt(request.getParameter("second_CategoryId"));
        int third_CategoryId = Integer.parseInt(request.getParameter("third_CategoryId"));
        BigDecimal price = BigDecimal.valueOf(Float.parseFloat(request.getParameter("price")));
        BigDecimal average_Cost = BigDecimal.valueOf(Float.parseFloat(request.getParameter("average_Cost")));
        int publish_Status = Integer.parseInt(request.getParameter("publish_Status"));
        int audit_Status = Integer.parseInt(request.getParameter("audit_Status"));
        Date production_Date = Date.valueOf(request.getParameter("production_Date"));
        int shelf_Life = Integer.parseInt(request.getParameter("shelf_Life"));
        String description = (String) request.getParameter("description");
        int inventory_Number = Integer.parseInt(request.getParameter("inventory_Number"));
        String picture = (String) request.getParameter("picture");

        Product product = new Product();
        product.setProduct_Core(product_Core);
        product.setProduct_Name(product_Name);
        product.setDrug_Name(drug_Name);
        product.setGYZZ(GYZZ);
        product.setBrand_Id(brand_Id);
        product.setFirst_CategoryId(first_CategoryId);
        product.setSecond_CategoryId(second_CategoryId);
        product.setThird_CategoryId(third_CategoryId);
        product.set_Publish_Status(publish_Status);
        product.set_Audit_Status(audit_Status);
        product.setProduction_Date(production_Date);
        product.setShelf_Life(shelf_Life);
        product.setDescription(description);
        product.setInventory_Number(inventory_Number);
        product.setPictures(picture);
        DoAddProduct dap = new DoAddProduct();
        try {
            if (dap.do_AddProduct(product, price, average_Cost)) {
                session.setAttribute("addStatus", "1");
                response.sendRedirect("administratorAddProduct.jsp");

            } else {
                session.setAttribute("addStatus", "0");
                response.sendRedirect("administratorAddProduct.jsp");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
