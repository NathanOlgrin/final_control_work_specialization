package model.service;

import model.animals_list.Domestic_animals;
import model.pets.*;

import java.time.LocalDate;

public class Service {
    private Domestic_animals domesticAnimals;

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
}
