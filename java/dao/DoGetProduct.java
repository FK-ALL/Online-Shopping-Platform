package dao;

import java.sql.*;

import beans.*;

public class DoGetProduct {
    public Product do_GetProduct(int product_Id) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();

        if (conn != null) {
            String sql = "select * from product_information where product_Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, product_Id);

            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                ps.close();
                rs.close();
                conn.close();
                return null;
            } else {
                rs.next();
                if (rs.getInt("publish_Status") == 1) {
                    Product product = new Product();
                    product.setProduct_Id(product_Id);
                    product.setProduct_Core(rs.getString("product_Core"));
                    product.setProduct_Name(rs.getString("product_Name"));
                    product.setDrug_Name(rs.getString("drug_Name"));
                    product.setGYZZ(rs.getString("GYZZ"));
                    product.setBrand_Id(rs.getInt("brand_ID"));
                    product.setFirst_CategoryId(rs.getInt("first_CategoryId"));
                    product.setSecond_CategoryId(rs.getInt("second_CategoryId"));
                    product.setThird_CategoryId(rs.getInt("third_CategoryId"));
                    product.setPrice(rs.getFloat("price"));
                    product.setAverage_Cost(rs.getFloat("average_Cost"));
                    product.setProduction_Date(rs.getDate("production_Date"));
                    product.setShelf_Life(rs.getInt("shelf_Life"));
                    product.setDescription(rs.getString("description"));
                    product.setSales(rs.getInt("sales"));
                    product.setInventory_Number(rs.getInt("inventory_Number"));

                    // 商品图片
                    sql = "select * from product_picture_information where product_Id = ? order by picture_Order";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, product_Id);
                    rs = ps.executeQuery();

                    if (!rs.isBeforeFirst()) {
                        product.setPictures();
                    } else {
                        while (rs.next()) {
                            if (rs.getInt("picture_Status") == 1) {
                                product.setPictures(rs.getString("picture_Url"));
                            }
                        }

                    }

                    ps.close();
                    rs.close();
                    conn.close();
                    return product;
                }
                ps.close();
                rs.close();
                conn.close();
            }

        }

        return null;

    }
}
