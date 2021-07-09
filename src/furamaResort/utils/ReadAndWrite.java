package furamaResort.utils;
//note: thêm while vô --> k display ra ds , bỏ đi --> ok??

import furamaResort.models.employee.AcademicLevel;
import furamaResort.models.employee.Employee;

import java.io.*;
import java.util.*;

public class ReadAndWrite {  //OK
    public Object readData(File file) {  //7.4:   sửa: đổi List<T> --> Objects<T>
        Object listObject = new Object();
        ObjectInputStream oips = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            oips = new ObjectInputStream(new FileInputStream(file));
            listObject = oips.readObject();
        }
//        catch (EOFException e) {   //EOFException - nếu luồng đầu vào chạm đến cuối trước khi đọc tám byte.   OK
//            System.err.println("List is empty");
//        }
        catch (ClassNotFoundException | IOException e) {
            System.out.println("File is Empty");
        } finally {
            if (oips != null) {
                try {
                    oips.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listObject;
    }

    //ham write:
    public void writeData(String path, Object list) {  //OK
        ObjectOutputStream oops = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            oops = new ObjectOutputStream(new FileOutputStream(file));
            oops.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oops != null) {
                try {
                    oops.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

