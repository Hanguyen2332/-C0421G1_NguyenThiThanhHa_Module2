package _13_thuat_toan_tim_kiem;

public class Optional2 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
//        System.out.println(find(arr,9));
        int left = 0;
        int right = arr.length - 1;
        System.out.println(timBangDeQuy(arr,left,right,14));
    }

    //C1:
//    public static int find(int[] arr, int value) {
//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right) {
//            int middle = (left + right) / 2;
//            if (arr[middle] == value) {
//                return middle;
//            } else if (value < arr[middle]) {
//                right = middle - 1;
//            } else {
//                left = middle + 1;
//            }
//        }
//        return -1;
//    }
    //C2: đệ quy
    public static int timBangDeQuy(int[] arr, int left, int right, int value) {
        if (left <= right) {  //DK dừng đệ quy
            int middle = (left + right) / 2;
            if (arr[middle] == value) {
                return middle;
            } else if (value < arr[middle]) {
                return timBangDeQuy(arr, left, middle - 1, value);
            } else {
                return timBangDeQuy(arr, left + 1, right, value);
            }
        }
        return-1;
    }
}
