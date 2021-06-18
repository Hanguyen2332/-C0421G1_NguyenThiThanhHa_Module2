package _11_stack_queue.excercise;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Bt2CountDisplayOfElement {
    public static void main(String[] args) {
        //khởi tạo treeMap
        TreeMap<String,Integer> stringTree = new TreeMap<String,Integer>();
        //tạo chuỗi
        String str = "Buon oi la buon vi chuan bi di hoc offline lai";
        //cắt chuỗi thành mảng
        String [] arr = str.split(" ");
        System.out.println(Arrays.toString(arr));
        //duyệt mảng --> đẩy vào treeMap
        for(int i = 0; i<arr.length; i++) {
            String word = arr[i].toUpperCase();
            //nếu từ chưa tồn tại trong treemap:
            if(!stringTree.containsKey(word)) {
                stringTree.put(word,1);
            }else {
                //nếu từ ĐÃ tồn tại trong treemap:
                int countValue = stringTree.get(word) + 1;  //get(Object key): trả về value liên kết với key được chỉ định
                stringTree.put(word,countValue);//dk: chưa đúng
            }
        }
        //duyet treeMap:
        for (Map.Entry<String,Integer> string: stringTree.entrySet()) { //entrySet() :
            System.out.println(string.getKey() + ", " + string.getValue());
        }
    }
}
