package _12_collectionFramework.excercise;

import java.util.*;

public class ArrayList_ProductManager {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//            Product product1 = new Product(1,"Cơm gà",25);
//            Product product2 = new Product(2,"Mì gà",20);
//            Product product3 = new Product(3,"Đậu hũ lướt ván",22.5);
//            Product product4 = new Product(4,"Bò nó 3 ngon",70);
        List<Product> products = new ArrayList<>();
//        //Gọi hàm thêm
        addProduct(products);
        addProduct(products);
        addProduct(products);
//        //gọi hàm display:
        displayProducts(products);
        //gọi hàm sủa:
        editProduct(products);
        displayProducts(products);
        //gọi hàm xóa:
        removeProduct(products);
        //gọi hàm display:
        displayProducts(products);
        //gọi hàm search():
        System.out.println(searchByName(products));
        //thêm
        addProduct(products);
        //sắp xếp:
        System.out.println("sort by price: ");
        sortByPrice(products);
    }

    public static void addProduct(List<Product> products) {
        int id = Integer.parseInt(inputOutput("input ID:"));
        String name = inputOutput("input product's name:");
        double price = Double.parseDouble(inputOutput("input price: "));
        Product product = new Product(id, name, price);
        products.add(product);
        System.out.println("add new element successfully");
    }

    public static void editProduct(List<Product> products) {
        int id = Integer.parseInt(inputOutput("input ID of element you wanna edit:"));
        boolean check = false;
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                check = true;
                int newId = Integer.parseInt(inputOutput("input new ID"));
                String newName = inputOutput("input product's name:");
                double newPrice = Double.parseDouble(inputOutput("input price: "));
                Product product = new Product(newId, newName, newPrice);
                products.set(i, product);
                break;
            }
        }
        if (!check) {
            System.out.println("NOT found this ID");
        }
    }

    public static void removeProduct(List<Product> products) {
        int id = Integer.parseInt(inputOutput("input ID of element you wanna Remove:"));
        boolean check = false;
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.remove(i);  //trả về đối tượng vừa xóa
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("NOT found this ID");
        }
    }

    public static void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("ArrayList Products is EMPTY!");
        } else {
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
    }

    //hàm tìm tên theo sản phẩm:
    public static Product searchByName(List<Product> products) {
        String nameProduct = inputOutput("input name of product you wanna search: ");
        Map<String, Product> map = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            map.put(products.get(i).getName(), products.get(i));
        }
        return map.get(nameProduct);
    }
    //hàm sắp xếp sản phẩm theo giá:

    public static void sortByPrice(List<Product> products) {
        Comparator compareByPrice = new PriceComparator();
        products.sort(compareByPrice);
        for(Product product: products) {
            System.out.println(product);
        }
    }

    public static String inputOutput(String str) {
        System.out.println(str);
        return sc.nextLine();
    }
}


