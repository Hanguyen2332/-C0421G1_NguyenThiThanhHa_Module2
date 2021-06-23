package _13_thuat_toan_tim_kiem;

import java.util.LinkedList;
import java.util.Scanner;

public class LongestAscending {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter string: ");
        String string = input.nextLine();

        //tạo List lưu kết quả
        LinkedList<Character> result = new LinkedList<>();
        LinkedList<Character> tempList = new LinkedList<>();
        // Tìm chuỗi tăng dần có độ dài lớn nhất
        for (int i = 0; i < string.length(); i++) {
            //Khai báo một linked list trung gian các kí tự của chuỗi tăng dần
//            LinkedList<Character> tempList = new LinkedList<>();
            //thêm kí tự thứ i vào trong list, so sánh với từng phần tử nằm sau nó
            tempList.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                //Kiểm tra kí tự tiếp theo có lớn hơn kí tự cuối cùng trong list hay không
                if (string.charAt(j) > tempList.getLast()) {
                    //Nếu có thì thêm vào trong list --> tạo list các ký tự tăng dần
                    tempList.add(string.charAt(j));
                }
            }
            //So sánh kích cỡ của list trung gian và list chứa chuỗi tăng dần có kích thước lớn nhất
            if (tempList.size() > result.size()) {
                //Nếu kích cỡ của list trung gian lớn hơn kích cỡ của list có độ dài lớn nhất thì gán lại max
                result.clear();
                result.addAll(tempList);
            }
            //đưa list tạm về lại rỗng --> quay lại vòng lặp mới
            tempList.clear();
        }

        // Hiển thị kết quả
        for (Character ch : result) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
