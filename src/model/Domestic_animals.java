package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Domestic_animals <E extends AnimalGenerality<E>> implements Serializable {
    private int animalId;
    private List<E> animalList;

    public Domestic_animals(){
        this(new ArrayList<>());
    }
    public Domestic_animals(List<E> animalList) {
        this.animalList = animalList;
    }

    public boolean add(E )

}
