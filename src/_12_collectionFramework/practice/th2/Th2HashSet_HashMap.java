package _12_collectionFramework.practice.th2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Th2HashSet_HashMap {
    public static <studentMap> void main(String[] args) {
        //Khoi tao các object student:
        Student student1 = new Student("Tran Thanh", 22, "HCM");
        Student student2 = new Student("Truong Giang", 20, "Quang Nam");
        Student student3 = new Student("Park Hang Seo", 18, "Han Quoc");
        Student student4 = new Student("Nguyen Thi Thanh Ha", 21, "DakLak");
        Student student5 = new Student("Le Be La", 19, "Lam Dong");
        //Test1:  HashMap, lưu student:
        Map<String, Student> studentMap = new HashMap<>();
        studentMap.put("Mot", student1);
        studentMap.put("hai", student2);
        studentMap.put("ba", student3);
        studentMap.put("bon", student4);
        studentMap.put("năm", student5);
        //duyệt map, in ra các key: keySet()
//        for (String key : studentMap.keySet()) {
//            System.out.println("key: " + key);
//        }
//        //duyệt map, in ra các value: kết hợp keySet() & get(key):
//        for (String key : studentMap.keySet()) {  //nếu không dùng entrySet() --> không thể gọi method key.getKey() & key.getValue()
//            System.out.println("value: " + studentMap.get(key));  // NOTE: studentMap.get(key) --> TRUE  key.get(key)  -->FALSE!!!!
//        }
        //duyệt Map, dùng Map.entry<> và listObject.entrySet():
        System.out.println("student list in HashMap: ");
        for (Map.Entry<String, Student> key : studentMap.entrySet()) {
            System.out.println(key); //in ra 1 set nguyên cục gồm: key-value
//            System.out.println("\n" + key.toString()); //giống y bên trên
//            System.out.println(key.getKey() + ", " + key.getValue()); //in ra từng yếu tố riêng, nối bằng ký tự mình muốn
        }

        //Test 2: DÙNG HashSet
        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.add(student4);
        studentSet.add(student1);
        System.out.println("\n student list in HashSet: ");
        for (Student student: studentSet)
        System.out.println(student);
    }
}
