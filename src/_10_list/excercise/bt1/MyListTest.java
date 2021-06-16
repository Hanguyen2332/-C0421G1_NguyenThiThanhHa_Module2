package _10_list.excercise.bt1;

class MyListTest {
    public static void main(String[] args) {
        MyList<String> listInteger1 = new MyList<String>(5);
        listInteger1.add(0, "value 1");
        listInteger1.add(1, "value 2");
        listInteger1.add(2, null);

        //test get():
        System.out.println(listInteger1.get(0));
        System.out.println(listInteger1.get(1));
        //test remove():
        listInteger1.remove(3);
        System.out.println(listInteger1.remove(1));
        System.out.println(listInteger1.size());

        //test method clone:
        System.out.println("in ra mảng clone");
        MyList<String> list2 = listInteger1.clone();
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
        //test indexOf(), contains():
        System.out.println(listInteger1.indexOf("value 3"));
        System.out.println(listInteger1.contains("value 3"));

        //test boolean add():
        System.out.println(listInteger1.add("value add"));
        //test clear():
        System.out.println("sau khi clear: ");
        list2.clear();
        System.out.println(list2.get(0));
        System.out.println(list2.get(1));
    }
}
