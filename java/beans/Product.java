package beans;

import java.sql.Date;
import java.util.*;

public class Product {
    private int product_Id;
    private String Product_Core;
    private int brand_Id;
    private int first_CategoryId;
    private int second_CategoryId;
    private int third_CategoryId;
    private int shelf_Life;
    private int sales;
    private int inventory_Number;
    private Date production_Date;
    private List<String> pictures;

    private String product_Name;
    private String drug_Name;
    private String GYZZ;// 国药准字
    private String description;

    private float price;
    private float average_Cost;

    private boolean publish_Status;
    private boolean audit_Status;
    private int _publish_Status;// 添加商品用
    private int _audit_Status;// 添加商品用

    public Product() {
        this.pictures = new ArrayList<String>();
    }

    public void setProduct_Id(int product_Id) {
        this.product_Id = product_Id;
    }

    public int getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Core(String Product_Core) {
        this.Product_Core = Product_Core;
    }

    public String getProduct_Core() {
        return Product_Core;
    }

    public void setFirst_CategoryId(int first_CategoryId) {
        this.first_CategoryId = first_CategoryId;

    }

    public int getFirst_CategoryId() {
        return first_CategoryId;
    }

    public void setSecond_CategoryId(int second_CategoryId) {
        this.second_CategoryId = second_CategoryId;

    }

    public int getSecond_CategoryId() {
        return second_CategoryId;
    }

    public void setThird_CategoryId(int third_CategoryId) {
        this.third_CategoryId = third_CategoryId;

    }

    public int getThird_CategoryId() {
        return third_CategoryId;
    }

    public void setShelf_Life(int shelf_Life) {
        this.shelf_Life = shelf_Life;

    }

    public int getShelf_Life() {
        return shelf_Life;
    }

    public void setSales(int sales) {
        this.sales = sales;

    }

    public int getSales() {
        return sales;
    }

    public void setInventory_Number(int inventory_Number) {
        this.inventory_Number = inventory_Number;

    }

    public int getInventory_Number() {
        return inventory_Number;
    }

    public void setBrand_Id(int brand_Id) {
        this.brand_Id = brand_Id;

    }

    public int getBrand_Id() {
        return brand_Id;
    }

    public void setProduction_Date(Date production_Date) {
        this.production_Date = production_Date;
    }

    public Date getProduction_Date() {
        return production_Date;
    }

    public void setDrug_Name(String drug_Name) {
        this.drug_Name = drug_Name;
    }

    public String getDrug_Name() {
        return drug_Name;
    }

    public void setGYZZ(String GYZZ) {
        this.GYZZ = GYZZ;
    }

    public String getGYZZ() {
        return GYZZ;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setAverage_Cost(float average_Cost) {
        this.average_Cost = average_Cost;
    }

    public float getAverage_Cost() {
        return average_Cost;
    }

    public void setPublish_Status(boolean publish_Status) {
        this.publish_Status = publish_Status;
    }

    public boolean isPublish_Status() {
        return publish_Status;
    }

    public void setAudit_Status(boolean audit_Status) {
        this.audit_Status = audit_Status;
    }

    public boolean isAudit_Status() {
        return audit_Status;
    }

    public void set_Publish_Status(int _publish_Status) {
        this._publish_Status = _publish_Status;
    }

    public int get_Publish_Status() {
        return _publish_Status;
    }

    public void set_Audit_Status(int _audit_Status) {
        this._audit_Status = _audit_Status;
    }

    public int get_Audit_Status() {
        return _audit_Status;
    }

    public void setPictures(String picturePath) {
        this.pictures.add(picturePath);
    }

    public void setPictures() {
        this.pictures = null;
    }

    public List<String> getPictures() {
        return pictures;
    }
}