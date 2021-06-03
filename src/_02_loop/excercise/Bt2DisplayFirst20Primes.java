package _02_loop.excercise;

public class Bt2DisplayFirst20Primes {

    public static void main(String[] args) {
        int countPrime = 0;
        int number = 1;
        while (countPrime < 20) {
            int count = 0;       //nhớ: khai báo biến count trong loop --> sau mỗi lẫn lặp update về 0, đếm lại từ đầu .
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(number + "  ");
                countPrime++;
            }
            number++;
        }
    }
}

