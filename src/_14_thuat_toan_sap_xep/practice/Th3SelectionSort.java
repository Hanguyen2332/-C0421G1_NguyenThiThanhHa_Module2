package _14_thuat_toan_sap_xep.practice;

import java.util.Arrays;

public class Th3SelectionSort {
    public static void main(String[] args) {
        int[] arr = {14, 3, 2, 5, 6, 1, -2, 3, 2, 12};
        System.out.println(selectionSort(arr));
    }
    public static String selectionSort(int[] list) {
        //NOTE: không đặt cờ "needSort" cho dạng selectionSort, vì bản chất và cách so sánh-sắp xếp khác bubbleSort.
        //bubbleSort: so sánh và đổi chỗ từng cặp phần tử (nếu phát hiện lớn/bé hơn)
        for (int i = 0; i<list.length; i++) {
            //gán vị trí đầu tiên = max;
            int max = i;
            for (int j = i + 1; j < list.length; j ++) {
                if (list[max] < list[j]) {
                    max = j;  //ghi nhận vị trí phần tử lớn nhất
                }
            }
            //đổi chỗ phần tử đang xét với max (chỉ swap 1 lần). note: nếu swap trong vòng for
            // --> phải swap nhiều lần với bất kỳ giá trị nào > max --> sai ý tưởng
            if(max != i) {
                int temp = list[i];
                list[i] = list[max];
                list[max] = temp;
            }
        }
        return Arrays.toString(list);
    }
}
