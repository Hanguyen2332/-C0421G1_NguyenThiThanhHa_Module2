package _01_introduce_java.excercise;

import java.util.Scanner;

public class Bt2ConverCurrencyToWord {
    public static void main(String[] args) {
        Scanner inputNumber = new Scanner(System.in);
        System.out.println("what is the number you want to covert? ");
        int number = inputNumber.nextInt();
        int hangTram = number / 100;
        int hangChuc = (number % 100) / 10;  //113%100= 13/10 = 1  ..1
        int hangDonVi = (number % 100) % 10; //123%100 = 23%10 =3
        int nhoHonHaiMuoi = (number % 100); // 11, 12, 13  ///  113? 213? 313?

        if (number <= 10) {
            chuyenDoiHangDonVi(hangDonVi);
        } else if (number < 20) {
            soNhoHonHaiMuoi(nhoHonHaiMuoi);
        } else if (number < 1000) {
            chuyenDoiHangTram(hangTram);
            if (hangChuc == 1) {
                soNhoHonHaiMuoi(nhoHonHaiMuoi);
            } else {
                chuyenDoiHangChuc(hangChuc);
                chuyenDoiHangDonVi(hangDonVi);
            }
        }
        if (number <= 0 || number >= 1000) {
            System.out.println(" out of ability");
        }
    }

    public static void chuyenDoiHangTram(int hangTram) {
        String word = "";
        switch (hangTram) {
            case 1:
                word = "one hundred";
                break;
            case 2:
                word = "two hundred";
                break;
            case 3:
                word = "three hundred";
                break;
            case 4:
                word = "four hundred";
                break;
            case 5:
                word = "five hundred";
                break;
            case 6:
                word = "six hundred";
                break;
            case 7:
                word = "seven hundred";
                break;
            case 8:
                word = "eight hundred";
                break;
            case 9:
                word = "nine hundred";
                break;
        }
        System.out.print(word + " ");
    }

    public static void chuyenDoiHangChuc(int hangChuc) {
        String word = "";
        switch (hangChuc) {
            case 2:
                word = "twenty";
                break;
            case 3:
                word = "Thirty";
                break;
            case 4:
                word = "forty";
                break;
            case 5:
                word = "fifty";
                break;
            case 6:
                word = "sixty";
                break;
            case 7:
                word = "seventy";
                break;
            case 8:
                word = "eighty";
                break;
            case 9:
                word = "ninety";
                break;
        }
        System.out.print(word + " ");
    }

    public static void chuyenDoiHangDonVi(int hangDonVi) {
        String word = "";
        switch (hangDonVi) {
            case 1:
                word = "one";
                break;
            case 2:
                word = "two";
                break;
            case 3:
                word = "three";
                break;
            case 4:
                word = "four";
                break;
            case 5:
                word = "five";
                break;
            case 6:
                word = "six";
                break;
            case 7:
                word = "seven";
                break;
            case 8:
                word = "eight";
                break;
            case 9:
                word = "nine";
                break;
            case 10:
                word = "ten";
                break;
        }
        System.out.print(word + " ");
    }

    public static void soNhoHonHaiMuoi(int numberLessThanTwenty) {
        String word = "";
        switch (numberLessThanTwenty) {
            case 11:
                word = "eleven";
                break;
            case 12:
                word = "twelve";
                break;
            case 13:
                word = "thirteen";
                break;
            case 14:
                word = "fourteen";
                break;
            case 15:
                word = "fifteen";
                break;
            case 16:
                word = "sixteen";
                break;
            case 17:
                word = "seventeen";
                break;
            case 18:
                word = "eighteen";
                break;
            case 19:
                word = "nineteen";
        }
        System.out.print(word + " ");
    }
}
