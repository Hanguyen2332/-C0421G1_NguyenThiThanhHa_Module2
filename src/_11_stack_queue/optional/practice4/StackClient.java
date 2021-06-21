package _11_stack_queue.optional.practice4;

public class StackClient {
    public static void main(String[] args) throws Exception {
        MyStack<Integer> arrStack = new MyStack<Integer> (5);
        //test push():
        arrStack.push(1);
        arrStack.push(2);
        arrStack.push(3);
        arrStack.push(4);
        arrStack.push(5);
//        arrStack.push(6);
//        arrStack.push(3);
//        arrStack.push(3);
//        arrStack.push(3);
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());
    }

}
