package _07_abstrack_interface.practice.Th1.fruits;

public class TestFruitAndInterface {
    public static void main(String[] args) {
        Fruit []fruit = new Fruit[2];
        fruit[0] = new Apple();
        fruit[1] = new Orange();
        for (Fruit element: fruit) {
            System.out.println(element.howToEat());
        }
    }
}
