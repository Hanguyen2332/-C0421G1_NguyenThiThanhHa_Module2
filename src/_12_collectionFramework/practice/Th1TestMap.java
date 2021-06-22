package _12_collectionFramework.practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Th1TestMap {
    public static void main(String[] args) {
        //khởi tạo Hashmap, chèn phần tử
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Đông", 18);
        hashMap.put("Tây", 20);
        hashMap.put("Nam", 19);
        hashMap.put("Bắc", 21);
        System.out.println("Display student list entry HashMap: " + hashMap);
        //TreeMap hiển thị toàn bộ key theo thứ tự giảm/tăng.
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap); //truyền tham chiếu = tập hợp
        System.out.println("Display student list entry HashMap: " + treeMap);
        //khởi tạo LinkedHashmap, chèn phần tử
        LinkedHashMap<String, Integer> linkedHashmap = new LinkedHashMap<>();
        linkedHashmap.put("Đông", 18);
        linkedHashmap.put("Tây", 20);
        linkedHashmap.put("Nam", 19);
        linkedHashmap.put("Bắc", 21);
        System.out.println("Display student list entry LinkedHashMap: " + linkedHashmap);
    }
}
