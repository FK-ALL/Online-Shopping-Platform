package dao;

import java.math.BigDecimal;
import java.sql.*;

import beans.*;

public class DoAddProduct {
    public boolean do_AddProduct(Product product, BigDecimal price, BigDecimal average_Cost) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "insert into product_information (product_Core,product_Name,drug_Name,GYZZ, brand_Id,first_CategoryId,second_CategoryId,third_CategoryId,price,average_Cost,publish_Status,audit_Status,production_Date,shelf_Life,description,inventory_Number) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getProduct_Core());
            ps.setString(2, product.getProduct_Name());
            ps.setString(3, product.getDrug_Name());
            ps.setString(4, product.getGYZZ());
            ps.setInt(5, product.getBrand_Id());
            ps.setInt(6, product.getFirst_CategoryId());
            ps.setInt(7, product.getSecond_CategoryId());
            ps.setInt(8, product.getThird_CategoryId());
            ps.setBigDecimal(9, price);
            ps.setBigDecimal(10, average_Cost);
            ps.setInt(11, product.get_Publish_Status());
            ps.setInt(12, product.get_Audit_Status());
            ps.setDate(13, product.getProduction_Date());
            ps.setInt(14, product.getShelf_Life());
            ps.setString(15, product.getDescription());
            ps.setInt(16, product.getInventory_Number());
            int i = ps.executeUpdate();

            String sql1 = "select product_Id from product_information where product_Core = ? and product_Name = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, product.getProduct_Core());
            ps1.setString(2, product.getProduct_Name());
            ResultSet rs = ps1.executeQuery();
            if (rs.isBeforeFirst()) {
                rs.next();
                String sql2 = "insert into product_picture_information (product_Id,picture_Url,picture_Description,picture_Order,picture_Status) values(?,?,?,?,?)";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setInt(1, rs.getInt("product_Id"));
                ps2.setString(2, product.getPictures().get(0));
                ps2.setString(3, "");
                ps2.setInt(4, 1);
                ps2.setInt(5, 1);
                int j = ps2.executeUpdate();
                if (i > 0 && j > 0) {
                    ps.close();
                    conn.close();
                    return true;
                } else {
                    ps.close();
                    conn.close();
                    return false;
                }
            }

        }
        return false;

    }

    public boolean do_AddProduct(Product product, BigDecimal price, BigDecimal average_Cost, int sales)
            throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {

            String sql = "insert into product_information (product_Id,product_Core,product_Name,drug_Name,GYZZ, brand_Id,first_CategoryId,second_CategoryId,third_CategoryId,price,average_Cost,publish_Status,audit_Status,production_Date,shelf_Life,description,sales,inventory_Number) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, product.getProduct_Id());
            ps.setString(2, product.getProduct_Core());
            ps.setString(3, product.getProduct_Name());
            ps.setString(4, product.getDrug_Name());
            ps.setString(5, product.getGYZZ());
            ps.setInt(6, product.getBrand_Id());
            ps.setInt(7, product.getFirst_CategoryId());
            ps.setInt(8, product.getSecond_CategoryId());
            ps.setInt(9, product.getThird_CategoryId());
            ps.setBigDecimal(10, price);
            ps.setBigDecimal(11, average_Cost);
            ps.setInt(12, product.get_Publish_Status());
            ps.setInt(13, product.get_Audit_Status());
            ps.setDate(14, product.getProduction_Date());
            ps.setInt(15, product.getShelf_Life());
            ps.setString(16, product.getDescription());
            ps.setInt(17, product.getSales());
            ps.setInt(18, product.getInventory_Number());
            int i = ps.executeUpdate();

            if (i > 0) {
                ps.close();
                conn.close();
                return true;
            } else {
                ps.close();
                conn.close();
                return false;
            }

        }
        return false;

    }
}
