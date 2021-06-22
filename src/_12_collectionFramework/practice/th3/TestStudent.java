package _12_collectionFramework.practice.th3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student("Nhat", 19, "Quảng Nam");
        Student student1 = new Student("Tai", 22, "Đà Nẵng");
        Student student2 = new Student("Dep", 25, "Quảng Bình" );
        Student student3 = new Student("Phuc", 17, "Hà Tĩnh" );

        List<Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        //test Comparable:
        System.out.println("So sanh theo TÊN:");
        Collections.sort(lists);  //hoặc tên object colletion.sort()   NOTE: nếu cấu trúc là mảng: Arrays.sort(mảng object)
        //in ra kết quả sau khi sort
        for(Student element : lists){
            System.out.println(element.toString());
        }
        //test Comparator:
        ComparatorByAge ageComparator = new ComparatorByAge();
        Collections.sort(lists,ageComparator);  //hoặc tên object lists.sort(ageComparator)   NOTE: nếu cấu trúc là mảng: Arrays.sort(mảng object,ageComparator)
        System.out.println("So sanh theo TUỔI:");
        for(Student element : lists){
            System.out.println(element.toString());
        }
    }
}
