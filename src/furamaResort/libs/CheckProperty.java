package furamaResort.libs;

public class CheckProperty {

    //check field thuộc tính:
    public static String checkInputProperty(String[] arr) {
        //hiển thị menu giá trị:
        System.out.println("There are " + arr.length + " options:  ");  //ok
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + ". " + arr[i]);
        }

        //nhap lua chon
        String value = null;
        boolean check = false;
        do {
            int choice = CheckValid.checkIntException();
            //check - gan value
            for (int i = 0; i < arr.length; i++) {
                if ((choice - 1) == i) {
                    value = arr[i];
                    check = true;
                    System.out.println("ok");
                    break;
                }
            }
            if (!check) {
                System.err.println("This choice is NOT available. Please enter value from 1 to " + arr.length);
            }
        } while (!check);
        return value;
    }
}
