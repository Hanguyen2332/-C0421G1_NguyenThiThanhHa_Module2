package _07_abstrack_interface.practice.Th1.animal;

import _07_abstrack_interface.practice.Th1.Edible;
import _07_abstrack_interface.practice.Th1.animal.Animal;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "quác quác!!!";
    }

    @Override
    public String howToEat() {
        return "dùng chân để bươi, dùng mỏ để mổ";
    }
}