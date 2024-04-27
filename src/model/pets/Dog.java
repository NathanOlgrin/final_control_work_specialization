package model.pets;

import java.time.LocalDate;

public class Dog extends Pet{

    public Dog(int id, String name, String commands, LocalDate birthday) {
        super(id, name, commands, birthday);
    }
}
