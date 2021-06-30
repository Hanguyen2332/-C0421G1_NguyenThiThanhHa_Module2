package _17_binary_file.excercise;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ReadAndWrite {
    static Scanner sc = new Scanner(System.in);

    //hàm write:
    public void writeToFile(File file, List<Product> products) {
        ObjectOutputStream oops = null;
        try {
            if (!file.exists()) {
                System.out.println("file is NOT exist! Create new file");
                file.createNewFile();
            }
            oops = new ObjectOutputStream(new FileOutputStream(file));
            oops.writeObject(products); // Ghi list đối tượng vào file
            System.out.println("Write to file completely!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oops != null) {
                try {
                    oops.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //hàm read():
    public List<Product> readFile(File file) {
        List<Product> result = null;
        ObjectInputStream ois = null;
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            result = (List<Product>) ois.readObject();  //gán Nội dung đã đọc được cho biến result (explicit kiểu Object --> List)
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {  //file chưa được mở --> khỏi đóng
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    //hàm search:
    public void searchProductByName(File file) {
        List<Product> list = readFile(file);
        System.out.println("Enter product's name: ");
        String name = sc.nextLine();
        boolean check = false;
        for (Product element : list) {
            if (name.equals(element.getName())) {
                System.out.println(element.toString());
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("NOT found this product in file");
        }
    }
}



