package _02_loop.excercise;

import com.sun.org.apache.xpath.internal.objects.XNumber;

public class Bt3DisplayPrimesLessThan100 {

    public static void main(String[] args) {
        //C1: Biến đếm
        int number = 2;
        for (int i = 1; i < 100; i++) {
            int count = 0;
            for (int j = 1; j <= number; j++) {
                if (number % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(number + "  ");
            }
            number++;
        }

        ////C2: đặt flag
//        int number = 2;
//        while (number <= 100) {
//            boolean check = true;
//            for (int i = 2; i <= Math.sqrt(number); i++) {
//                if (number % i == 0) {
//                    check = false;
//                    break;
//                }
//            }
//            if (check) {
//                System.out.print(number + " ");
//            }
//            number++;
//        }
    }
}
