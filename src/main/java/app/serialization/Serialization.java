package app.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
    public void escrever(List<Object> list, String fileToSer){
        try {
            String pwd = System.getProperty("user.dir");


            File serializationFiles = new File(pwd + "\\src\\main\\serializationFiles");
            if (!serializationFiles.exists()) {
                serializationFiles.mkdirs();
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pwd + "\\src\\main\\serializationFiles\\" + fileToSer));
            try {
                oos.writeObject(list);
            }finally {
                oos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Object> ler(String fileToSer){
        String pwd = System.getProperty("user.dir");
        File f = new File(pwd + "\\src\\main\\serializationFiles\\" + fileToSer);
        if (f.exists()) {
            List<Object> objects;
            try {

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pwd + "\\src\\main\\serializationFiles\\" + fileToSer));
                try {
                    objects = (List<Object>) ois.readObject();
                } finally {
                    ois.close();
                }
                return objects;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }else{
            return new ArrayList<>();
        }
    }
}
