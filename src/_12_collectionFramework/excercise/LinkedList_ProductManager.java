package _12_collectionFramework.excercise;

import java.util.*;

public class LinkedList_ProductManager {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Product> products = new LinkedList<>();
        do {
            System.out.println("Menu: \n" +
                    "1. Add new Product\n" +
                    "2. Edit Product \n" +
                    "3. Remove Product\n" +
                    "4. Display Product\n" +
                    "5. Search Product by Name\n" +
                    "6. Sorting Procduct by price\n" +
                    "7. Exit\n" +
                    "Please enter your choice:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addProduct(products);
                    break;
                case 2:
                    editProduct(products);
                    break;
                case 3:
                    removeProduct(products);
                    break;
                case 4:
                    displayProducts(products);
                    break;
                case 5:
                    searchByName(products);
                    break;
                case 6:
                    sortByPrice(products);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("The number you entered is not valid. Please choose again: ");
            }
        } while (true);
    }

    public static void addProduct(List<Product> products) {
        int id = Integer.parseInt(inputOutput("input ID:"));
        for (int i = 0; i < products.size(); i++) {
            //kiểm tra, không cho nhập ID trùng lặp
            if (products.get(i).getId() == id) {
                System.out.println("ID cannot be duplicated! Please enter again: ");
                id = Integer.parseInt(inputOutput("input ID:"));
            }
        }
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
                String newName = inputOutput("input product's name:");
                products.get(i).setName(newName);
                double newPrice = Double.parseDouble(inputOutput("input price: "));
                products.get(i).setPrice(newPrice);
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
    public static void searchByName(List<Product> products) {
        String nameProduct = inputOutput("input name of product you wanna search: ");
        Map<String, Product> map = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            map.put(products.get(i).getName(), products.get(i));
        }
        System.out.println(map.get(nameProduct));
    }
    //hàm sắp xếp sản phẩm theo giá:

    public static void sortByPrice(List<Product> products) {
        products.sort(Product::compareTo);
        System.out.println("After sorting by price: ");
        for (Product product: products) {
            System.out.println(product);
        }
    }

    public static String inputOutput(String str) {
        System.out.println(str);
        return sc.nextLine();
    }
}
