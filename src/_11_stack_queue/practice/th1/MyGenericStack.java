package _11_stack_queue.practice.th1;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList<>();
    }

    public void push(T element) {
        stack.addFirst(element); // vì ốc mượn hồn, đang mượn LinkedList--> lưu trữu data--> có thể gọi method của LinkedList.
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst(); //giá trị return nằm trong block scope --> không đc à?

    }

    public int size() {
        return stack.size();

    }
    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
