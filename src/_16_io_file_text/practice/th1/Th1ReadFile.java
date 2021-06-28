package _16_io_file_text.practice.th1;

import java.io.*;

public class Th1ReadFile {
    public static void main(String[] args) {
        //nhập đường link file:
        final String FILE_PATH = "D:\\module2\\src\\_16_io_file_text\\practice\\th1\\number";
        //gọi hàm đọc - tính tổng
        readFileText(FILE_PATH);
    }

    public static void readFileText(String filePath) {
        try {
            File file = new File(filePath);  // (mở) nạp file
            if (!file.exists()) {
                throw new FileNotFoundException(); //nếu file k tồn tại --> ném ra Ex
            }
            FileReader number = new FileReader(file); //đưa file vào --> đọc
            BufferedReader bf = new BufferedReader(number); //nối file cần đọc vs bộ nhớ đệm --> đọc nhanh hơn
            String readInAline; //khởi tạo biến line kiểu String (vì hàm readLine (): return String)
            int sum = 0;
            while ((readInAline = bf.readLine()) != null) { //readLine(): đọc nội dung file (theo từng dòng của file)
                System.out.println(readInAline);  //hiển thị từng dòng nội dung file
                sum+=Integer.parseInt(readInAline); //chuyển chuỗi --> số, tính tổng (vì hàm readLine (): return String)
            }
            bf.close(); // đóng file lại
            System.out.println("sum = " + sum); //hiển thị kết quả
        } catch (Exception e) {  //TẠI SAO: nếu dung IOException--> chỉ truy vết lỗi, k in ra đc dòng sout?
//            e.printStackTrace();
            System.out.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }
}
/* tóm lại: các bước ĐỌC file:
1. MỞ (nạp) fie: File inputFile = new File(...);
2. đưa file vào máy đọc: FileReader ...
3. Tạo bộ nhớ đệm --> truyền file đọc cần bộ nhớ đệm vào : BufferedReader....
4. tạo biến (con trỏ)--> đọc từng dòng nội dung file (cho đến khi null): while (bộ_nhớ_đệm.readLine()) != null)
5. ĐÓNG file: bộ_nhớ_đệm.close(); (vì hiện chỉ đang thao tác với bộ nhớ đệm)
note: tất cả được bọc trong try-catch (vì các class đều có throws)
 */