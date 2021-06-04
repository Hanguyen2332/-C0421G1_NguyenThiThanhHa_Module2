package _03_array_method.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class Bt4MaxElementOfTwoDimensionArray {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println("Enter row of matrix: ");
//        int row = input.nextInt();
//        System.out.println("Enter row of matrix: ");
//        int column = input.nextInt();
        findMaxElement();
    }

    private static void findMaxElement() {
        System.out.println("Enter row of matrix: ");
        int row = input.nextInt();
        System.out.println("Enter row of matrix: ");
        int column = input.nextInt();
        float[][] matrix = new float[row][column];
        float maxElement = matrix[0][0];
        int maxRow = 0;
        int maxColumn = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("Enter element at index [%d][%d] ", i, j);
                matrix[i][j] = input.nextFloat();
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }
        System.out.println("matrix = " + Arrays.deepToString(matrix));
        System.out.printf("MAX element of matrix is %f at index row = %d column = %d ", maxElement, maxRow, maxColumn);
    }
}
