package _11_stack_queue.practice.th2;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queueLinkedList = new MyLinkedListQueue();
        queueLinkedList.enqueue(1);  //ok
        queueLinkedList.enqueue(2);
        queueLinkedList.enqueue(3);
        queueLinkedList.enqueue(4);
        System.out.print("Dequeued item is: " + queueLinkedList.dequeue().key); //ok
        System.out.print("\n Dequeued item is: " + queueLinkedList.dequeue().key);
        queueLinkedList.enqueue(5);
        queueLinkedList.enqueue(5);
        queueLinkedList.enqueue(6);
    }
}
