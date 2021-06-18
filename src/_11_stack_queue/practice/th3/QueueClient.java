package _11_stack_queue.practice.th3;

public class QueueClient {
    public static void main(String[] args) throws Exception {
        MyQueue arrQueue = new MyQueue(5);
        //test isEmpty
        System.out.println("Queue is empty?   " + arrQueue.isQueueEmpty());
        //test enqueue():
        arrQueue.enqueue(1);
        arrQueue.enqueue(2);
        arrQueue.enqueue(3);
        arrQueue.enqueue(4);
        //test isFull():
        System.out.println("Queue is empty?   " + arrQueue.isQueueFull());
        //test dequeue():
        arrQueue.dequeue();
        arrQueue.dequeue();
        arrQueue.dequeue();


    }
}
