package _11_stack_queue.practice.th1;

public class GenericStackClient {
    public static void main(String[] args) {
        System.out.println("1. Stack of String: ");
        stackOfStrings();
        System.out.println("2. Stack of Integer: ");
        stackOfIntegers();
    }
    private static void stackOfStrings() {
        MyGenericStack<String> stackString = new MyGenericStack<String>();
        stackString.push("one");
        stackString.push("two");
        stackString.push("three");
        stackString.push("four");
        stackString.push("five");
        System.out.println("size = " + stackString.size());
        System.out.println("pop element from stack: ");
        while (!stackString.isEmpty()) {
            System.out.println(stackString.pop());
        }
        System.out.println("size of stack after pop operations: " + stackString.size());
    }
    private static void stackOfIntegers() {
        MyGenericStack<Integer> stackInt = new MyGenericStack<>();
        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);
        stackInt.push(4);
        stackInt.push(5);
        System.out.println("size = " + stackInt.size());
        System.out.println("pop element from stack: ");
        while (!stackInt.isEmpty()) {
            System.out.println(stackInt.pop());
        }
        System.out.println("size of stack after pop operations: " + stackInt.size());
    }
}

