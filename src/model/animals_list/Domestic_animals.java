package model.animals_list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Domestic_animals <E extends AnimalGenerality<E>> implements Serializable {
    private int animalId;
    private int count_dogs;
    private int count_cats;
    private int cout_hamsters;
    private List<E> animalList;

    public Domestic_animals(){
        this(new ArrayList<>());
    }
    public Domestic_animals(List<E> animalList) {
        this.animalList = animalList;
    }

    public boolean add(E pet){
        if (pet == null){
            return false;
        }
        animalList.add(pet);
        pet.setId(animalId++);
        switch (pet.getType()){
            case Собака -> {
                count_dogs++;
                break;
            }
            case Кот -> {
                count_cats++;
                break;
            }
            case Хомяк -> {
                cout_hamsters++;
                break;
            }
            default -> {
                break;
            }
        }
        return true;
    }


    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В питомнике ");
        sb.append(animalList.size());
        sb.append(" животных. Из них: ");
        sb.append(count_dogs);
        sb.append(" собак, ");
        sb.append(count_cats);
        sb.append(" котов/кошек, ");
        sb.append(cout_hamsters);
        sb.append(" хомяков.");
        return sb.toString();
    }

    public String getList(){
        StringBuilder sb = new StringBuilder();
        sb.append("Список животных: \n");
        for(E pet : animalList){
            sb.append(pet);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getInfoList(){
        StringBuilder sb = new StringBuilder();
        sb.append(getInfo());
        sb.append("\n");
        sb.append(getList());
        return sb.toString();
    }

    private boolean checkId(int id){
        return  id < animalId && id >= 0;
    }

    public E getById(int id){
        for(E pet : animalList){
            if(pet.getId() == id){
                return pet;
            }
        }
        return null;
    }

    public boolean remove(int animalId){
        if(checkId(animalId)){
            E e = getById(animalId);
            return animalList.remove(e);
        }
        return false;
    }

}
