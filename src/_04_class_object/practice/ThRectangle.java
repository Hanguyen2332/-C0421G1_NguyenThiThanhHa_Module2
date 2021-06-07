package _04_class_object.practice;

import java.util.Scanner;

public class ThRectangle {
    float width;
    float height;
    ThRectangle() {    // cái này có chức năng gì? có thực sự cần thiết k??
    }
     ThRectangle(float newWidth,float newHeight) {
        this.width = newWidth;   // khác JS: chỉ có 1 hàm tạo, và khai báo+khởi tạo thuộc tính trực tiếp
         this.height = newHeight; //          this.width = width; ==>  dataField + Ctructor (2) = Ctructor của JS.
    }
    public float getArea() {      // tại sao KHÔNG thể dùg:  STATIC cho Method??
        return width*height;
    }
    public float getPerimeter() {
        return (width+height)*2;
    }
    public String display() {
        return "Rectangle{"+ "width = " + width + "; height = " + height +"}";
    }
}
class Runtime {
    public static void main(String[] args) {  // đối tượng mới không thể tạo riêng biệt bên ngoài như JS? mà bắt buộc phải tạo bên trong 1 class mới để runtime à?
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Rectangle width: ");
        float width = sc.nextFloat();
        System.out.println("Enter Rectangle width: ");
        float height = sc.nextFloat();
        ThRectangle myRectangle = new ThRectangle(width,height);
        System.out.println(myRectangle.display());
        System.out.println("Rectangle's area = " + myRectangle.getArea());
        System.out.println("Rectangle's perimeter = " + myRectangle.getPerimeter());
    }
}
