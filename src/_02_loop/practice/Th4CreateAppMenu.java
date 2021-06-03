package _02_loop.practice;

import java.util.Scanner;

public class Th4CreateAppMenu {

    public static void main(String[] args) {
        Scanner inputChoice = new Scanner(System.in);
        while (true) {
            System.out.println("Menu: \n" +
                    "1. Draw the triangle \n" +
                    "2. Draw the square \n" +
                    "3. Draw the rectangle \n" +
                    "0. Exit\n" +
                    "Please enter your choice");
            int choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Please enter triangle height: ");
                    int h = inputChoice.nextInt();
                    for (int i = 0; i < h; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("\r");
                    }
                    break;
                case 2:
                    System.out.println("Please enter square size: ");
                    int size = inputChoice.nextInt();
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println("\r");
                    }
                    break;
                case 3:
                    System.out.println("Please enter rectangle height : ");
                    int height = inputChoice.nextInt();
                    System.out.println("Please enter rectangle width: ");
                    int width = inputChoice.nextInt();
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println("\r");
                    }
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}

