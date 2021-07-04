package furamaResort.utils;
//note: thêm while vô --> k display ra ds , bỏ đi --> ok??
import furamaResort.models.employee.AcademicLevel;
import furamaResort.models.employee.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReadAndWrite<T> {  //OK
    public Collection<T> readData(File file) {  //7.4: sửa: đổi List<T> --> Collection<T>
        Collection<T> listObject = new ArrayList<>();
        ObjectInputStream oips = null;
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            oips = new ObjectInputStream(new FileInputStream(file));
                listObject = (Collection<T>) oips.readObject();
        } catch (EOFException e) {   //EOFException - nếu luồng đầu vào chạm đến cuối trước khi đọc tám byte.   OK
            System.err.println("List is empty");
        }
        catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
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
    public void writeData(String path, Collection<T> list) {  //OK
        ObjectOutputStream oops = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            oops = new ObjectOutputStream(new FileOutputStream(file));
            oops.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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

