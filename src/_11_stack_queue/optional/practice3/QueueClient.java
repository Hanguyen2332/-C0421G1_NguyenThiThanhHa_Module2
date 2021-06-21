package _11_stack_queue.optional.practice3;

public class QueueClient {
    public static void main(String[] args) throws Exception {
        MyQueue arrQueue = new MyQueue(5);
        //test TH: tail = capacity - 1
        System.out.println("--------// test TH: tail = capacity - 1   //----------");
        System.out.println("Queue is empty?   " + arrQueue.isQueueEmpty());
        arrQueue.enqueue(1);
        arrQueue.enqueue(2);
        arrQueue.enqueue(3);
        arrQueue.enqueue(4);
        arrQueue.enqueue(5);
        System.out.println("Queue is Full?   " + arrQueue.isQueueFull());
        arrQueue.dequeue();
        arrQueue.dequeue();
        System.out.println("Queue is Full?   " + arrQueue.isQueueFull());
        arrQueue.enqueue(6);
        arrQueue.enqueue(7);
        //test TH head = capacity - 1
        System.out.println("--------// test TH: head = capacity - 1   //----------");
        arrQueue.dequeue();
        arrQueue.dequeue();
        arrQueue.dequeue();
        arrQueue.dequeue();
        arrQueue.dequeue();
        System.out.println("Queue is empty?   " + arrQueue.isQueueEmpty());
        arrQueue.enqueue(8);
        arrQueue.enqueue(9);
        arrQueue.enqueue(10);
        System.out.println("Queue is empty?   " + arrQueue.isQueueEmpty());
        arrQueue.dequeue();
        arrQueue.dequeue();
    }
}
