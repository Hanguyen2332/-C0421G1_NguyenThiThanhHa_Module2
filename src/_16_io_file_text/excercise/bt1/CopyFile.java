package _16_io_file_text.excercise.bt1;
//nhận xét: đã sao chép được file, nhưng chưa sử dụng  được đúng chức năng của hàm checkIsExist.
import java.io.*;
import java.util.Scanner;

public class CopyFile {
    static Scanner sc = new Scanner(System.in);
    static final String SOURCE_PATH = "D:\\module2\\src\\_16_io_file_text\\excercise\\bt1\\source_file";
    static final String TARGET_PATH = "D:\\module2\\src\\_16_io_file_text\\excercise\\bt1\\target_file";

    public static void main(String[] args) {
        //lấy nội dung từ file nguồn
        String content = readFile(SOURCE_PATH);
        //gọi hàm --> sao chép đến file đích
        writeFile(TARGET_PATH, content);
    }

    //method input stream:
    public static String readFile(String path) {// ok
        String result = "";
        //tạo đối tượng cho File thực:
        File file = new File(path);
        //check file isExist:
        checkIsExist(file);
        try {
            //tạo bộ nhớ đệm
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            //đọc file
            String readByLine;
            while ((readByLine = bufferedReader.readLine()) != null) {
                result += readByLine + "\n";
            }
            bufferedReader.close(); //đóng file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //method output stream:
    public static void writeFile(String path, String content) { //hàm checkIsExist: đưa vào k có ý nghĩa
        //tạo đối tượng đại diện cho file đích:
        File file = new File(path);
        //check isExist:
        checkIsExist(file);
        try {
            //Tạo bộ nhớ đệm
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            //ghi file:
            bufferedWriter.append(content);
            bufferedWriter.close(); //đóng file
            System.out.println("copy to target file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //ham checkIsExist:
    public static void checkIsExist(File file) {
        FileWriter fileWriter = null;
        if (!file.exists()) {
            System.out.println("File NOT exist!"); //nếu file đích chưa tồn tại --> tạp file mới --> ok
            try {
                file.createNewFile();
                fileWriter = new FileWriter(file);
                String content = sc.nextLine();
                fileWriter.append(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists!");  // nếu file đích đã tồn tại --> cần làm gì?
        }
    }
}
