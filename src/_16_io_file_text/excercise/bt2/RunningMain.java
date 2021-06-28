package _16_io_file_text.excercise.bt2;

import java.util.List;

public class RunningMain {
    public static void main(String[] args) {
        WriteAndReadFileCsv object = new WriteAndReadFileCsv();
        //gọi hàm viết
        object.writeFile();
        //gọi hàm đọc
//        List<CountryList> displayList = object.readFile();
//        for (CountryList e : displayList)
//            System.out.println(e.toString());
    }
}
