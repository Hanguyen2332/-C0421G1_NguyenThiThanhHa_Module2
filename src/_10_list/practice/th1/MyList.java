package _10_list.practice.th1;

import java.util.Arrays;

 class MyList<E> {   //E: THAM SỐ HÓA kiểu dữ liệu (generic) --> M: tái sử dụng code, khi chạy chương trình, ưng truyền kiểu dữ liệu gì vào cg ok!
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private Object []elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY]; //khi khởi tạo đối tượng --> sẽ tạo luôn 1 mảng đối tượng tham chiếu 10 phần tử
    }
    //tăng kích thước mảng:
    private void ensureCapa() {
        if(size >=elements.length) {
            //C1: sử dụng hàm System.arraycopy(mảng gốc,int copy tù,mảng mới,int sao chép từ,from);

//            Object[] newElements = new Object[size*2]  ;
//            System.arraycopy(elements,0,newElements,0,size);
//            elements = newElements;

            //C2: sử dụng hàm Arrays.copyOf(mảng gốc,độ dài mới):
            int newSize = elements.length*2;
            elements = Arrays.copyOf(elements,newSize); //Arrays.copyOf(elements,newSize) : elements: mảng gốc, mảng mới có độ dài newSize;
        }
    }
    //thêm phần tử vào cuối mảng:
    public void add(E e) {
        this.ensureCapa();      //kiểm tra mảng full or not?
        elements[size++] = e;  //thêm phần tử
    }
    //Check index có hợp lệ không? khai báo luồng ngoại lệ
    private void checkIndex(int index){
        if(index < 0 || index >=size) {
            throw new IndexOutOfBoundsException  //NOTE: Tên throw : Pascal Case;
                    ("index " + index + " out of bounds ( arrayList size = " + size + ")");
        }
    }
    public E get(int i) {
     this.checkIndex(i);
     return (E) elements[i];
    }
}
