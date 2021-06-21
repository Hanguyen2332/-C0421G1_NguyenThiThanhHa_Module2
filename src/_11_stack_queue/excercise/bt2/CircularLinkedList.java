package _11_stack_queue.excercise.bt2;

public class CircularLinkedList {
    static Node front;
    static Node rear;

    public CircularLinkedList() {
    }

    public void enQueue(int data) {
        Node temp = new Node(data);
        if (rear == null) {
            rear = front = temp;
        } else {
            rear.link = temp; //thêm Node mới vào cuối LinkedList
            rear = temp;   // nhích con trỏ rear tới, cho trỏ đến Node mới
        }
        rear.link = front; //tạo vòng, cho Node cuối trỏ đến Node đầu
    }

    public void deQueue() throws Exception {
        Node temp;
        if (front == null) {
            throw new Exception("Queue is Empty");
        } else if (front == rear) { //NOTE: chú ý sắp xếp các TH if/else hợp lý
            temp = front;
            front = rear = null;
        } else {
            temp = front;
            front = front.link; //cho front trỏ đến Node sau nó, pop Node đầu ra
            rear.link = front;// cập nhật lại rear: cho trỏ đến Node đầu (tạo lại vòng)
        }
        System.out.println("Removed: " + temp.data);
    }

    public void displayQueue() {
        Node temp = front;
        for (int i = 0; temp.link != front; i++) {
            System.out.println(temp.data);
            temp = temp.link;  // = temp++
        }
        System.out.println(temp.data); //loop chạy tới vị trí rear --> in ra giá trị tại rear
    }
}
