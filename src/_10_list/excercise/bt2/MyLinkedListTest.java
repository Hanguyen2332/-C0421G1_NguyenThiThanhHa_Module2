package _10_list.excercise.bt2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> linkList = new MyLinkedList<>("Node head");
        linkList.add(1,"Node 1");
        linkList.add(2,"Node 2");
        linkList.add(3,"Node 3");

        //test size():   //ok
        System.out.println("size = " + linkList.size());  //OK
        //test printList():  //ok
        System.out.println("in ra cac element của List:");
        linkList.printList();
        //test addLast():
        linkList.addLast("Node 4");
        System.out.println("check addLast: " + linkList.getLast());
        //check get():  //ok
        System.out.println("getIndex: " + linkList.get(2));
        //check getFirst():  //ok
        System.out.println("getFirst: " + linkList.getFirst());
        //check getLast():  //ok
        System.out.println("getLast: " + linkList.getLast());
        //check remove(index):
        System.out.println("remove(index 2) : " + linkList.remove(2));  //ok
        System.out.println("remove(index 0) : " + linkList.remove(0));  //ok
        //check remove(Object)
        System.out.println("remove: " + linkList.remove("Node 2"));//OK: NHỚ previous.next.data --> truy xuất value của Node đó., nếu không --> SAI!
        //test contains():
        System.out.println("contains: " + linkList.contains("Node 1"));  //OK
        //test indexOf() :
        System.out.println("indexOf() : " + linkList.indexOf("Node 3"));  //OK
        System.out.println("indexOf() : " + linkList.indexOf("Node 5"));  //OK
        //test clone():
        System.out.println("clone(): " + linkList.clone());  //OK
        //test clear():
        System.out.println("after clear: ");  //OK
        linkList.clear();
    }
}
