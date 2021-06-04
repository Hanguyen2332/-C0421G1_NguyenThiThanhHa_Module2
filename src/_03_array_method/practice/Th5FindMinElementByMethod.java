package _03_array_method.practice;

public class Th5FindMinElementByMethod {

    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        findMinElement(arr);
    }

    private static void findMinElement(int[] arr) {
        int minElement = arr[0];
        int indexMin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
                indexMin = i;
            }
        }
        System.out.printf("MIN element is %d at index %d ", minElement, indexMin);
    }
}
