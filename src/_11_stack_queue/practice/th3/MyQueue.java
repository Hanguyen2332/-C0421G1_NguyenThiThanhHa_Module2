package _11_stack_queue.practice.th3;

import java.util.Queue;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head;
    private int tail;
    private int currentSize;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;//Note: nếu không set giá trị cho capacity --> lỗi: độ dài mảng luôn = 0;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        if (currentSize == capacity) {
            return true;
        }
        return false;
    }

    public boolean isQueueEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }
    public void enqueue(int item) throws Exception { //thêm cuối
        if (this.isQueueFull()) {
            throw new Exception("Queue is FULL! Can NOT enqueue!");
        } else {
            //tăng con trỏ tail lên --> trỏ tới ô trống tiếp theo,gán giá trị
            tail = tail + 1;
            queueArr[tail] = item;
            //tăng size
            currentSize++;
            System.out.println("add Successfully! added: " + queueArr[tail]);
        }
    }

    public void dequeue() throws Exception { //lấy đầu
        if (this.isQueueEmpty()) {
            throw new Exception("Queue is EMPTY! Can NOT dequeue!");
        } else {
            //tăng con trỏ head lên 1 đơn vị --> chỉ tới phần tử phía sau
            head++;
            int removeData = queueArr[head];
            //giảm size
            currentSize--;
            System.out.println("dequeue Successfully. removed: " + removeData);
        }
    }
}

