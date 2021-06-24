package _14_thuat_toan_sap_xep.excercise;

import sun.applet.Main;

import java.util.Arrays;

public class Bt2InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 6, 1, -2, 3, 14, 12};
        System.out.println(insertionSort(arr));
    }

    //C1: dùng for()
    public static String insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int checkElement = list[i];
            int index = i;
            //dịch mảng ra sau, tạo chỗ trống
            for (int j = i; j > 0 && checkElement < list[j-1]; j--) {
                list[j] = list[j-1];
                index = j-1; //vì list[j-1] --> j chỉ chạy đến vị trí ngay trước chỗ cần chèn
            }
            //chèn:
            list[index] = checkElement;
        }
        return Arrays.toString(list);
    }
}

    //C2: dùng while:
//    public static String insertionSort(int[] list) {
//        for (int i = 1; i < list.length; i++) {
//            int checkElement = list[i];
//            int index = i;
//            //dồn mảng ra phía sau
//            while (index > 0 && checkElement < list[index - 1]) { // nếu index>=0 --> list[index - 1] = -1 --> lỗi
//                list[index] = list[index - 1];
//                index--;
//            }
//            //chèn: sau lặp --> index chạy tới vị trí cần chèn --> chèn vào
//            list[index] = checkElement;
//        }
//        return Arrays.toString(list);
//    }
//}
