package _17_binary_file.practice.th1;
// NOTE: fixbug cả ngày --> cuối cùng sai đường dẫn (sourcePath - destPath: bỏ cùng 1 link file! ngu như bò)
import java.io.*;

class CopyFile {
    public static void copyFile(String sourcePath, String destPath) {
        InputStream fileInputStream = null;
        OutputStream fileOutputStream = null;
        try {
//            check isExist;
            File sourFile = new File(sourcePath);
            File destFile = new File(destPath);
            if (!sourFile.exists() || !destFile.exists()) {
                throw new FileNotFoundException();
            }
            //khởi tạo file đọc/ghi:
            fileInputStream = new FileInputStream(sourcePath);
            fileOutputStream = new FileOutputStream(destPath);
            byte[] buffer = new byte[1024];  // tạo mảng tạm--> lưu kết quả đọc đc từ file nguồn vào mảng --> lấy nội dung mảng--> chép vào file đích
            int length;
            //ghi (copy) vào file đích
            while ((length = fileInputStream.read(buffer)) > 0) {  //NOTE: length: là số ký tự đọc được, KHÔNG PHẢI độ dài mảng byte[]
                fileOutputStream.write(buffer, 0, length);  //NOTE: buffer: mảng cần copy _ off:vị trí bắt đầu copy _ length: số byte cần copy
            }
            System.out.println("Completely!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

