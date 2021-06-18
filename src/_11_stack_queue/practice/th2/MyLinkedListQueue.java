package _11_stack_queue.practice.th2;

 class MyLinkedListQueue {
     private Node head;
     private Node tail;

     public MyLinkedListQueue() {
         this.head = null;
         this.tail = null;
     }
     public void enqueue(int key) {  //NOTE: thêm: vào cuối
         Node temp = new Node(key);  //NOTE :Rear ~ Tail. front  = head ==> cấu trúc queue NGƯỢC so với LinkedList
         if (this.tail == null) { //nếu List rỗng --> cho cả head & null đều chỉ vào Node mới
             head = tail = temp;
         }
         this.tail.next = temp;  // thêm mới vào cuối mảng (sau tail hiện tại).
         this.tail = temp;   //dịch chuyển tail, cho trỏ đến phần tử mới
     }
     public Node dequeue() {//NOTE: thêm: ở đầu
         //check empty --> nếu đúng --> throw
         if(head==null) {
             throw new NullPointerException();
         }
         //nếu không --> dequeue
         Node temp = head;
         head = head.next;
         //sau khi lấy: nếu list bị rỗng --> cho head & tail cùng chỉ vào null
         if (this.head == null) {
             this.tail = null;
         }
         return temp;
     }
 }
