package Files;

import java.io.*;

public class FileManager {

    public FileManager(){

    }

    public Object load() {
        try {
            FileInputStream fileIn = new FileInputStream("Estado.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            objectIn.close();

            return obj;
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public Object load(String path) {
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            objectIn.close();

            return obj;
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public void save(Object obj) {
        try {

            FileOutputStream fileOut = new FileOutputStream("Estado.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(obj);

            objectOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String path, Object obj) {
        try {

            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(obj);

            objectOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
