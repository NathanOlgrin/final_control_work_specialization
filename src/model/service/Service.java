package model.service;

import model.animals_list.Domestic_animals;
import model.pets.*;
import model.writer.file_handler;

import java.time.LocalDate;

public class Service {
    private Domestic_animals domesticAnimals;
    private file_handler writable;

    public Service(){
        domesticAnimals = new Domestic_animals();
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

    public void saveList(){
        String filename = "src/save/list.txt";
        writable.save(domesticAnimals, filename);
    }

    public void loadSaveList(){
        String filename = "src/save/list.txt";
        domesticAnimals = (Domestic_animals) writable.load(filename);
    }
}
