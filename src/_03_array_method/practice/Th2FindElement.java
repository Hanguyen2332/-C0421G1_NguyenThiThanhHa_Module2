package _03_array_method.practice;

import java.util.Scanner;

public class Th2FindElement {
    public static void main(String[] args) {
        String[] studentList = {"Lụa","Loan","Lê","Long","Lan","lý"};
        Scanner inputName = new Scanner(System.in);
        System.out.println("Enter student's name: ");
        String findName = inputName.nextLine();
        boolean check = false;
        for(int i=0; i<studentList.length; i++) {
            if(findName.equals(studentList[i])) {
                System.out.println("This student's name is at index " + i);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("NOT found this name");
        }
    }
}
