package _07_abstrack_interface.practice.Th1.animal;

import _07_abstrack_interface.practice.Th1.Edible;
import _07_abstrack_interface.practice.Th1.animal.Animal;
import _07_abstrack_interface.practice.Th1.animal.Chicken;
import _07_abstrack_interface.practice.Th1.animal.Tiger;

public class TestAnimalAndInterface {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal element : animals) {
            System.out.println(element.makeSound());
            if (element instanceof Chicken) {
                Edible edible = (Chicken) element;  // 1.explicit element XUỐNG kiểu Chicken --> 2.Implicit LÊN kiểu Edible.
                System.out.println("Chicken: " + edible.howToEat());                            // edible: thuộc kiểu Edible
//                System.out.println("Chicken: " + ((Chicken) element).howToEat()); --> 0k. NOTE: element thuộc kiểu Chicken
            }
        }
    }
}
