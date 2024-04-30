package model.service;

import model.animals_list.Domestic_animals;
import model.pets.*;
import model.writer.Writable;

import java.time.LocalDate;

public class Service {
    private Domestic_animals domesticAnimals;
    private Writable writable;

    public Service(Writable writable){
        domesticAnimals = new Domestic_animals();
        this.writable = writable;
    }

    public void addPet(int choice, String name, String commands, LocalDate birthday){
        Pet pet;
        switch (choice){
            case 1:
                pet = new Dog(name, commands, birthday, Type.Собака);
                domesticAnimals.add(pet);
                break;
            case 2:
                pet = new Cat(name, commands, birthday, Type.Кот);
                domesticAnimals.add(pet);
                break;
            case 3:
                pet = new Hamster(name, commands, birthday, Type.Хомяк);
                domesticAnimals.add(pet);
                break;
            default:
                break;
        }
    }

    public void remove(int id){
        domesticAnimals.remove(id);
    }

    public String getInfoList(){
       return domesticAnimals.getInfoList();
    }

    public String getCommands(int id){
        return domesticAnimals.getCommands(id);
    }

    public boolean addCommands(int id, String commands){
        return domesticAnimals.addCommands(id, commands);
    }
    public void saveList(){
        String filename = "src/save/list.txt";
        writable.save(domesticAnimals, filename);
    }

    public void loadSaveList(){
        String filename = "src/save/list.txt";
        domesticAnimals = (Domestic_animals) writable.load(filename);
    }
}
