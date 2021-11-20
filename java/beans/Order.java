package beans;

import java.math.BigDecimal;

public class Order {
    private int order_Id;
    private int product_Id;
    private String user_RealName;
    private String address;
    private BigDecimal order_Money;
    private java.sql.Timestamp creat_Time;
    private java.sql.Timestamp receive_Time;
    private String product_Name;
    private int productPurchaseNumber;

    public Order(int order_Id, int product_Id, String user_RealName, String address, BigDecimal order_Money,
            java.sql.Timestamp creat_Time, java.sql.Timestamp receive_Time, String product_Name,
            int productPurchaseNumber) {
        this.order_Id = order_Id;
        this.product_Id = product_Id;
        this.user_RealName = user_RealName;
        this.address = address;
        this.order_Money = order_Money;
        this.creat_Time = creat_Time;
        this.receive_Time = receive_Time;
        this.product_Name = product_Name;
        this.productPurchaseNumber = productPurchaseNumber;
    }

    public int getOrder_Id() {
        return order_Id;
    }

    public int getProduct_Id() {
        return product_Id;
    }

    public String getUser_RealName() {
        return user_RealName;
    }

    public String getAddress() {
        return address;
    }

    public BigDecimal getOrder_Money() {
        return order_Money;
    }

    public java.sql.Timestamp getCreat_Time() {
        return creat_Time;
    }

    public java.sql.Timestamp getReceive_Time() {
        return receive_Time;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public int getProductPurchaseNumber() {
        return productPurchaseNumber;
    }
}
