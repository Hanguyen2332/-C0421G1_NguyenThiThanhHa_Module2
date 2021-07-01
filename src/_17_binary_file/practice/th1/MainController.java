package _17_binary_file.practice.th1;

import java.io.File;
import java.io.IOException;

class MainController {
    public static void main(String[] args) {
        String sourcePath = "D:\\module2\\src\\_17_binary_file\\practice\\th1\\source_file";
        String desPath = "D:\\module2\\src\\_17_binary_file\\practice\\th1\\des_file";
        CopyFile.copyFile(sourcePath, desPath);  //ok!
    }
}
