package _10_list.excercise.bt2;

import java.util.NoSuchElementException;

class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    public MyLinkedList(Object data) {
        head = new Node(data);  //tại sao không thể dùng: Node.getData() ??
        numNodes++;
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

    public void add(int index, E element) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {  //duyệt mảng, cho temp trỏ dần đến vị trí "cần xóa - 1"
            temp = temp.next;
        }
        //holder: value hiện tại ở vị trí cần chèn;
        holder = temp.next;
        //chèn node mới vào
        temp.next = new Node(element); // temp = new Node(element);
        //buộc node mới vào holder;
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {  //chưa ok: nếu head.next = null --> tail = head
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E e) {  //OK
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(e); //temp = new Node(e)  --> SAI!
        numNodes++;
    }

    public E remove(int index) {  //Xóa: chỉ cần bẻ gãy liên kết, loại phần tử đó ra khỏi List. KHÔNG cần gán cho element = null;
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("index: " + index + ", numNodes: " + numNodes);
        }
        Node temp = head;
        if (index == 0) {
            head = head.next;
            numNodes--;
            return (E) temp.data;
        } else {
            for (int i = 0; i < index && temp.next != null; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            numNodes--;
            return (E) temp.data;
        }
    }

    public boolean remove(Object e) {  //OK
        Node previous = head;
        for (int i = 0; previous != null; i++) {
            if (e.equals(previous.next.data)) {  //NOTE: nhớ previous.data , nếu không --> SAI!
                previous.next = previous.next.next;
                numNodes--;
                return true;
            }
            previous = previous.next;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        if (numNodes == 0) {
            throw new NullPointerException();
        }
        MyLinkedList<E> newLinkedList = new MyLinkedList<E>();
        Node temp = head;
        newLinkedList.addFirst((E) temp.data);
        while (temp.next != null) {
            temp = temp.next;
            newLinkedList.addLast((E) temp.data);
        }
        return newLinkedList;
    }

    public boolean contains(E o) {  //OK
        //C1:
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        if (temp.data.equals(o)) {
            return true;
        }
        return false;

//        //C2:
//        return indexOf(o) >=0;
    }

    public int indexOf(E o) {  //ok
        Node temp = head;
        for (int i = 0; temp != null; i++) {
            if (o.equals(temp.data)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public boolean add(E e) {
        this.addLast(e);
        return true;
    }

    public E get(int i) {
        Node current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return (E) current.data;  //Muốn in ra value của nốt, phải: temp.data, nếu không sẽ in ra hashcode của Node temp
    }

    public E getFirst() {  //OK
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            return (E) head.data;
        }
    }

    public E getLast() {  //OK
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            Node temp = head;
            for (int i = 0; temp.next != null; i++) {
                temp = temp.next;
            }
            return (E) temp.data;
        }
    }

    public void clear() {   //ook
        Node temp = head;
        for (int i = 0; temp.next != null; i++) {
            temp = temp.next = null;
        }
        head = null;
        numNodes = 0;
    }

    public void printList() {  //ok
        Node temp = head;
        System.out.println(temp.data);
        while (temp.next != null) {
            System.out.println(temp.next.data);
            temp = temp.next;
        }
    }
}
