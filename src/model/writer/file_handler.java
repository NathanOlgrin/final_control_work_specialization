package model.writer;

import model.pets.Pet;

import java.io.*;

public class file_handler implements Writable{
    @Override
    public boolean save(Serializable serializable, String filename) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Object load(String filename) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))){
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
