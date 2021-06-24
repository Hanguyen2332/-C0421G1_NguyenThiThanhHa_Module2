package _14_thuat_toan_sap_xep.practice;

import java.util.Arrays;

public class Th1BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        bubbleSort(arr);
    }

    //C1: đẩy phần tử NHỎ nhất về ĐẦU mảng --> co khoảng so sánh lại
    public static void bubbleSort(int[] list) {
        boolean needSort = true;  // khai báo = true --> thỏa mãn ĐK chạy Loop
        for (int i = 0; i < list.length && needSort; i++) {
            needSort = false;
            for (int j = list.length - 1; j > i; j--) {
                if (list[j] < list[j - 1]) {  // chạy hết vòng lặp for nhỏ --> check từng cặp số sau-trước.
                    int temp = list[j - 1]; // nếu số sau luôn lớn hơn số trước --> không bao giờ rơi vào if --> needSort = false --> thoát luôn khỏi vòng lặp lớn
                    list[j - 1] = list[j];  // không cần sort nữa.
                    list[j] = temp;
                    needSort = true;
                }
            }
        }
        System.out.println("list after bubble sorting: " + Arrays.toString(list));
    }

    //C2: đẩy phần tử LỚN nhất về CUỐI mảng --> co khoảng so sánh lại
//    public static void bubbleSort(int[] list) {
//        boolean needSort = true;  // giả sử mảng chưa được sắp xếp
//        for (int i = 1; i < list.length && needSort; i++) { //Vòng lặp để co khoảng check. Xét từ i = 1 --> để vòng con chạy từ 0 --> arr.length-1
//            needSort = false;
//            for (int j = 0; j < list.length-i; j++) { // Vòng lặp con: so sánh từng cặp phần tử
//                if (list[j] > list[j + 1]) {  //Sau mỗi vòng lặp --> phần tử lớn nhất đã đc đẩy về cuối mảng --> loại nó ra khỏi khoảng check
//                    int temp = list[j];
//                    list[j] = list[j + 1];
//                    list[j+1] = temp;
//                    needSort = true;
//                }
//            }
//        }
//        System.out.println("list after bubble sorting: " + Arrays.toString(list));
//    }
}
