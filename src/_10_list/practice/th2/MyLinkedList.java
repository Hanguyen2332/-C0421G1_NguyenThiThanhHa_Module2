package _10_list.practice.th2;

public class MyLinkedList {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
    }
    private class Node {
        private Node next;
        private Object data;
        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
    public void add(int index, Object data) {
        //tạo 2 biến tạm :temp, holder;
        Node temp = head;
        Node holder;
        //chạy vòng lặp for --> biến tạm "temp" trỏ dần đến vị trí "cần xóa - 1"
        //temp: liên tục đc cập nhật thành temp.next (mới) sau mỗi lần lặp, cho đến khi tới vị trí "index -1" --> temp: trở thành node tại nằm ngay trước vị trí cần chèn
        for(int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        //Lưu giá trị tại vị trí cần chèn cho biến tạm holder. (hiện đang link với temp ==> holder = temp.next).
        holder = temp.next;
        //cột temp vào Node mới vừa chèn.
        temp.next = new Node(data);
        //cột Node mới chèn vào holder
        temp.next.next = holder;
        //tăng size MyLinkList lên 1
        numNodes++;
    }
    public void addFirst (Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public Node get(int index){
        Node temp = head;
        for(int i=0; i < index;i++) { //khong lấy trực tiếp theo kiểu: arr[index] đc à?
            temp = temp.next;
        }
      return temp;
    }
    public void printList() {
        //gán biến tạm temp = head, cho in ra đầu đễn cuối List;
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            //update temp thành temp.next, cho tới khi gặp null
            temp = temp.next;
        }
    }
}
