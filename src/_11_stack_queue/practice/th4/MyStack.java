package _11_stack_queue.practice.th4;

class MyStack<T> {
    private int[] arr;
    private int size;
    private int index;  //top

    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void push(int element) {  //ok
        if (this.isFull()) {
            throw new StackOverflowError("Stack is full!");
        }
        index = index + 1;  // tăng top lên 1 --> trỏ tới ô nhớ trống trước, gán giá trị sau  --> top luôn chỉ đến giá trị hiện tại
        arr[index] = element;

//        arr[index] = element;  //arr[0] = element   //gán trước mới tăng --> top sẽ chỉ tới ô nhớ trống --> sai bản chất?
//        index++;
        System.out.println("add successfully: " + element);
    }

    public int pop() throws Exception {  //khi nào cần khai báo Throws??
        if (this.isEmpty()) {
            throw new Exception("Stack is null");
        }
        int data = arr[index];  //truy cập data tại top trước, giảm top xuống 1 đơn vị sau
        index--;
        return data;
//        return arr[--index];   //giảm trước, truy cập sau.
    }

    public boolean isEmpty() {
        if (index == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (index == size) {
            return true;
        }
        return false;
    }
}
//túm lại: khi pop, chỉ cần giảm top xuống 1 đơn vị là được, không cần gán giá trị tại ô nhớ đó = 0 à? (mảng Interger)
