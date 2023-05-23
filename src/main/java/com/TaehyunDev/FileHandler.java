package com.TaehyunDev;

import com.TaehyunDev.Guitar.Guitar;

import java.io.*;
import java.util.LinkedList;

public class FileHandler {

    public void saveData(LinkedList<Guitar> tempList){
        try{
            FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir") + "/GuitarData/data.ser"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tempList);
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public LinkedList<Guitar> loadData(){
        LinkedList<Guitar> tempList = new LinkedList<>();
        try {
            File file = new File(System.getProperty("user.dir") + "/GuitarData/data.ser");
            if (!file.exists()) {
                new File(System.getProperty("user.dir") + "/GuitarData").mkdir();
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            tempList = ((LinkedList<Guitar>) ois.readObject());
            ois.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tempList;
    }

}