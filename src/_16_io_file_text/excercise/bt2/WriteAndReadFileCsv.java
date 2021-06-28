package _16_io_file_text.excercise.bt2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFileCsv {
    static final String FILE_PATH = "D:\\module2\\src\\_16_io_file_text\\excercise\\bt2\\ListOfCountrys";
    static final String HEADER = "id,code,name";
    static final String BREAK = "\n";
    static final String COMMAND = ",";
    static List<CountryList> list = new ArrayList<>();

    static {
        list.add(new CountryList(1, "AU", "Australia"));
        list.add(new CountryList(2, "CN", "China"));
        list.add(new CountryList(3, "AU", "Australia"));
        list.add(new CountryList(4, "CN", "China"));
        list.add(new CountryList(5, "JP", "Japan"));
        list.add(new CountryList(6, "CN", "China"));
        list.add(new CountryList(7, "JP", "Japan"));
        list.add(new CountryList(8, "TH", "Thailand"));
    }

//    public static void main(String[] args) {
//        //gọi hàm viết
////       writeFile();
//        //gọi hàm đọc
//        List<CountryList> displayList = readFile();
//        for (CountryList e : displayList)
//            System.out.println(e.toString());
//    }


    //ghi file:
    public void writeFile() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true)); //file có update --> ngăn ghi đè
            bufferedWriter.append(HEADER);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.append(BREAK);
                bufferedWriter.append(String.valueOf(list.get(i).getId()));
                bufferedWriter.append(COMMAND);
                bufferedWriter.append(list.get(i).getCode());
                bufferedWriter.append(COMMAND);
                bufferedWriter.append(list.get(i).getName());
            }
            bufferedWriter.close();
            System.out.println("File has been recorded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //đọc file:
    public List<CountryList> readFile() {
        List<CountryList> outputList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedWriter = new BufferedReader(fileReader);
            String readByLine;
            int checkHeader = 0;
            while ((readByLine = bufferedWriter.readLine()) != null) {
                if (checkHeader == 0) {
                    checkHeader++;
                    continue;
                }
                String[] arr = readByLine.split(",");
                int id = Integer.parseInt(arr[0]);
                String code = arr[1];
                String name = arr[2];
                outputList.add(new CountryList(id, code, name));
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputList;
    }
}
