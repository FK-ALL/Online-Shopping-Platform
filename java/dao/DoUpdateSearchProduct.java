package dao;

import java.sql.*;
import java.util.*;

import beans.Product;

public class DoUpdateSearchProduct {
    public List<Product> do_UpdateSearchProduct(String productName) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "select * from product_information where product_Name like ? or product_Core like ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + productName + "%");
            ps.setString(2, "%" + productName + "%");
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                ps.close();
                rs.close();
                conn.close();
                return null;
            } else {
                List<Product> products = new ArrayList<Product>();
                while (rs.next()) {
                    Product product = new Product();
                    product.setProduct_Id(rs.getInt("product_Id"));
                    product.setProduct_Core(rs.getString("product_Core"));
                    product.setProduct_Name(rs.getString("product_Name"));
                    product.setDrug_Name(rs.getString("drug_Name"));
                    product.setGYZZ(rs.getString("GYZZ"));
                    product.setBrand_Id(rs.getInt("brand_ID"));
                    product.setFirst_CategoryId(rs.getInt("first_CategoryId"));
                    product.setSecond_CategoryId(rs.getInt("second_CategoryId"));
                    product.setThird_CategoryId(rs.getInt("third_CategoryId"));
                    product.setPrice((rs.getFloat("price")));
                    product.setAverage_Cost(rs.getFloat("average_Cost"));
                    product.set_Publish_Status(rs.getInt("publish_Status"));
                    product.set_Audit_Status(rs.getInt("audit_Status"));
                    product.setProduction_Date(rs.getDate("production_Date"));
                    product.setShelf_Life(rs.getInt("shelf_Life"));
                    product.setDescription(rs.getString("description"));
                    product.setInventory_Number(rs.getInt("inventory_Number"));

                    products.add(product);
                }
                ps.close();
                rs.close();
                conn.close();
                return products;
            }
        }
        return null;
    }
}
