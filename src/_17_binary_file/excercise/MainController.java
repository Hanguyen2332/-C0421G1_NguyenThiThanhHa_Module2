package _17_binary_file.excercise;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    public static void main(String[] args) {
        ReadAndWrite object = new ReadAndWrite();
        List<Product> products = new ArrayList<>();
        products.add(new Product("BCR11", "Bàn chải chà bồn cầu","ToiletCare", 45.5,"bệ sinh bồn cầu chuyên dụng"));
        products.add(new Product("V22", "VIM","ToiletCare", 60,"Nước sát khuẩn bồn cầu"));
        products.add(new Product("LS33", "Sun light","HomeCare", 55,"Nước lau sàn"));
        //tạo file
        File file = new File("D:\\module2\\src\\_17_binary_file\\excercise\\fileProduct");
//        goi ham write : ok
        object.writeToFile(file,products);
//        gọi hàm đọc:  ok
        List<Product> result = object.readFile(file); //đã ép kiểu trong hàm
        for (Product element: result) {
            System.out.println(element);
        }
//        //goi ham search(): ok
        object.searchProductByName(file);
    }
}
