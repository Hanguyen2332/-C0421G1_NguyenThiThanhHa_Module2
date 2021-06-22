package _12_collectionFramework.practice.th3;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }

//    @Override
//    public int compare(Student o1, Student o2) {
//        if(o1.getAge() > o2.getAge()){
//            return 1;
//        }else if(o1.getAge() == o2.getAge()){
//            return 0;
//        }else{
//            return -1;
//        }
//    }
}
