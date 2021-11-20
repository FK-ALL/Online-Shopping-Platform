package servlets;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import beans.*;

public class UpdateProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateProduct() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        int product_Id = Integer.parseInt(request.getParameter("product_Id"));
        String product_Core = (String) request.getParameter("product_Core");
        String product_Name = (String) request.getParameter("product_Name");
        String drug_Name = (String) request.getParameter("drug_Name");
        String GYZZ = (String) request.getParameter("GYZZ");
        int brand_Id = Integer.parseInt(request.getParameter("brand_Id"));
        int first_CategoryId = Integer.parseInt(request.getParameter("first_CategoryId"));
        int second_CategoryId = Integer.parseInt(request.getParameter("second_CategoryId"));
        int third_CategoryId = Integer.parseInt(request.getParameter("third_CategoryId"));
        int shelf_Life = Integer.parseInt(request.getParameter("shelf_Life"));
        int inventory_Number = Integer.parseInt(request.getParameter("inventory_Number"));
        Date production_Date = Date.valueOf(request.getParameter("production_Date"));
        BigDecimal price = BigDecimal.valueOf(Float.parseFloat(request.getParameter("price")));
        BigDecimal average_Cost = BigDecimal.valueOf(Float.parseFloat(request.getParameter("average_Cost")));
        String description = (String) request.getParameter("description");
        int publish_Status = Integer.parseInt(request.getParameter("_publish_Status"));
        int audit_Status = Integer.parseInt(request.getParameter("_audit_Status"));
        int sales = Integer.parseInt(request.getParameter("sales"));

        DoDeleteProduct ddp = new DoDeleteProduct();
        try {
            if (ddp.do_DeleteUpdateProduct(product_Id)) {
                Product product = new Product();
                product.setProduct_Id(product_Id);
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
                product.setSales(sales);
                product.setInventory_Number(inventory_Number);
                DoAddProduct dap = new DoAddProduct();
                if (dap.do_AddProduct(product, price, average_Cost, sales)) {
                    session.setAttribute("updateStatus", "1");
                    response.sendRedirect("administratorUpdateProduct.jsp");
                } else {
                    session.setAttribute("updateStatus", "0");
                    response.sendRedirect("administratorUpdateProduct.jsp");
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
