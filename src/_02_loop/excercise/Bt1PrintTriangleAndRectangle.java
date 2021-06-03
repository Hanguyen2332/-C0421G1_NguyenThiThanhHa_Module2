package _02_loop.excercise;

import java.util.Scanner;

public class Bt1PrintTriangleAndRectangle {
    public static void main(String[] args) {
        Scanner inputChoice = new Scanner(System.in);
        while (true) {
            System.out.println("Menu: \n" +
                    "1. Draw the rectangle \n" +
                    "2. Draw the square triangle \n" +
                    "3. Draw the isosceles triangle \n" +
                    "4. Exit\n" +
                    "Please enter your choice");
            int choice = inputChoice.nextInt();
            if (choice == 1) {
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
            } else if (choice == 2) {
                System.out.println("Please enter square triangle height: ");
                int h = inputChoice.nextInt();

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println("\r");
                }
                System.out.println("\r");
                for (int i = h; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                    System.out.println("\r");
                }

                System.out.println("\r\n");
                for (int i = 1; i <= h; i++) {
                    for (int j = 1; j <= h; j++) {
                        if (j <= (h - i)) {
                            System.out.print("  ");
                        } else {
                            System.out.print("* ");
                        }
                    }
                    System.out.println("\r");
                }
                System.out.println("\r");
                for (int i = 1; i <= h; i++) {
                    for (int j = 1; j <= h; j++) {
                        if (j <= i - 1) {
                            System.out.print("  ");
                        } else {
                            System.out.print("* ");
                        }
                    }
                    System.out.println("\r");
                }
            } else if (choice == 3) {
                System.out.println("Please enter isosceles triangle height: ");
                int h = inputChoice.nextInt();
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < 2 * h; j++) {
                        if (j >= h - i && j <= h + i) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println("\r");
                }
            } else if (choice == 0) {
                System.exit(0);
            }
        }
    }
}


