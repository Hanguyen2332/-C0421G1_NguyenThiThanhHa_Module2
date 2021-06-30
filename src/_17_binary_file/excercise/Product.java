package _17_binary_file.excercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

class Product implements Serializable {
     private String code;
     private String name;
     private String maker;
     private double price;
     private String description;

     public Product() {
     }

     public Product(String code, String name, String maker, double price, String description) {
         this.code = code;
         this.name = name;
         this.maker = maker;
         this.price = price;
         this.description = description;
     }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
