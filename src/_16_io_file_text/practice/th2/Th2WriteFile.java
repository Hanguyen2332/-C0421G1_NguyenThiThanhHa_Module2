package _16_io_file_text.practice.th2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Th2WriteFile {
    private static final String READ_PATH = "D:\\module2\\src\\_16_io_file_text\\practice\\th2\\number";
    private static final String WRITE_PATH = "D:\\module2\\src\\_16_io_file_text\\practice\\th2\\result";

    public static void main(String[] args) {
        //goi ham write
        int max = readFileAndFindMax(READ_PATH);
        writeMaxToFile(WRITE_PATH, max);
    }

    //B1: đọc file --> tìm max
    public static int readFileAndFindMax(String path) { //ok
        int max = 0;
        try {
            //nạp file
            File file = new File(READ_PATH);
            if (!file.exists()) {
                System.out.println("find not found or content is mismatch!");
            }
            //đưa file vào đọc:
            FileReader readFile = new FileReader(READ_PATH);
            //tạo bộ nhớ đệm:
            BufferedReader bf = new BufferedReader(readFile);
            //tạo biến tham chiếu đến từng dòng trong file (con trỏ):
            String readInLine;
            //tìm max:
            String[] str = null;
            while ((readInLine = bf.readLine()) != null) {
                str = readInLine.split(" "); // các numbers cách nhau khoảng trắng --> phải chuyển chuỗi --> mảng --> tìm max
                System.out.println(Arrays.toString(str)); //in ra mảng số nguyên
                max = findMaxNumber(str); //gọi hàm findMax
            }
            //đóng file
            readFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("max = " + max);
        return max;
    }

    //hàm find max:
    public static int findMaxNumber(String[] str) {  //ok
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            if (max < Integer.parseInt(str[i])) {
                max = Integer.parseInt(str[i]);
            }
        }
        return max;
    }

    //B2: ghi max ra file:
    public static void writeMaxToFile(String path, int max) {  //NG: Khi test báo Ex "file k tồn tại hoặc nội dung có lỗi"
        try {
//            //mở file rỗng:
            File newFile = new File(path);
            //lấy file --> ghi:
            FileWriter writeFile = new FileWriter(newFile);
            //tạo bộ nhớ đệm -->ghi:
            BufferedWriter bfw = new BufferedWriter(writeFile);
            //ghi: test 2 hàm
            bfw.write("max number = " + max);  //TẠI SAO: bfw.append(int c)  NHƯNG: bfw.wite(max) KHÔNG dùng được?
            bfw.append("max number = " + max);    //TẠI SAO: bfw.append(char c) NHƯNG:  bfw.append("max number = " + max) VẪN dùng đc?
            //đóng file:
            bfw.close();
            System.out.println("write file completely!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//hàm read: nếu không dùng buffer --> đọc trực tiếp từng ký tự, mà không đọc theo dòng thì:
//dùng hàm: readFile.read() : được không? tại sao khi dùng thử --> lỗi