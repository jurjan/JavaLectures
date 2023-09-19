package utils;

import model.Shop;

import java.io.*;

public class FileUtils {

    public static void writeToFile(String fileName, Shop shop) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(shop);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Arba gausiu null klaidos atveju, arba normalu objekta
    public static Shop readFromFile(String fileName) {
        Shop shop = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            shop = (Shop) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shop;
    }

}
