package furamaResort.utils;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadAndWriteMap<K,V> {
    //ham write:
    public void writeData(String path, Map<K,V> list) {  //OK
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
    public Map<K,V> readData(String path) {
        Map<K,V> objectMap = new LinkedHashMap<>();
        ObjectInputStream oips = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            oips = new ObjectInputStream(new FileInputStream(file));
            objectMap = (Map<K,V>) oips.readObject();
        } catch (EOFException e) {   //EOFException - nếu luồng đầu vào chạm đến cuối trước khi đọc tám byte.   OK
            System.err.println("");  //list rỗng thì khỏi in
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
        return objectMap;
    }
}
