package _11_stack_queue.optional.practice3;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head = 0;  //head luôn trỏ sẵn đến vị trí index = 0 (đầu mảng)==>khi dequeue: head++ =1 --> giá trị đầu mảng (tại index = 0) bị pop ra ngoài.
    private int tail = -1;  // để khi thêm phần tử mới --> tail ++ = 0 --> index đầu tiên đc gán giá trị (NOTE: chiều thêm: đi tù cuối mảng đến)
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

    public void enqueue(int item) throws Exception { //thêm: chiều thêm từ cuối vào
        if (this.isQueueFull()) {
            throw new Exception("Queue is FULL! Can NOT enqueue!");
        } else {
            /*KIỂM TRA ĐIỀU KIỆN XOAY VÒNG (liên tưởng Mảng vòng tròn):
            sau khi check if bên trên --> mảng chưa Full, nhưng tail đã chỉ đến vị trí index = length - 1 ==> không thể thêm mới,mặc dù phía đầu mảng trống.
            nguyên nhân: do sau QT thêm/bớt --> tail bị đẩy dần đến bờ vực thẳm :))
            --> cần check ĐK xoay vòng, gán cho tail = 0 --> tận dụng ô trống, tiếp tục gán giá trị mới:
             */
            if (tail == capacity - 1) {
                tail = 0;
            } else {
                //nếu không --> tăng con trỏ tail lên --> trỏ tới ô trống tiếp theo
                tail = tail + 1;
            }
            //gán giá trị
            queueArr[tail] = item;
            //tăng size
            currentSize++;
            System.out.println("Added: " + queueArr[tail] + ", index = " + tail);
        }
    }

    public void dequeue() throws Exception { //lấy đầu
        int removeData;
        int index;
        if (this.isQueueEmpty()) {
            throw new Exception("Queue is EMPTY! Can NOT dequeue!");
        } else {
            /*KIỂM TRA ĐIỀU KIỆN XOAY VÒNG: head đã tới vị trí length - 1, nhưng đầu mảng vẫn có phần tử
            do: tail thêm vào sau (bên trên)
            --> không tiếp tục dequeue được, dù vẫn còn phần tử (nếu tiếp tục head++ --> head >= length --> lỗi index vượt mảng)
            --> cần check, set lại head về 0
             */
            if (head == capacity - 1) {
                head = 0;
                removeData = queueArr[capacity - 1];
                index = capacity - 1;
            } else {
                //nêu không: tăng con trỏ head lên 1 đơn vị --> chỉ tới phần tử phía sau, loại phần tử trước
                head++;
                removeData = queueArr[head - 1]; //giá trị head vừa trỏ vào trước đó
                index = head - 1;
            }
            //giảm size
            currentSize--;
            System.out.println("Removed: " + removeData + ", index = " + index);
        }
    }
}

