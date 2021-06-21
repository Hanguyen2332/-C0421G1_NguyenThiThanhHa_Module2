package _11_stack_queue.excercise.bt2;

public class TestQueue {
    public static void main(String[] args) throws Exception {
        CircularLinkedList myQueue =  new CircularLinkedList();
        //test enQueue(): ok
        myQueue.enQueue(12);
        myQueue.enQueue(13);
        myQueue.enQueue(14);
        myQueue.enQueue(15);
        myQueue.displayQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
    }
}
