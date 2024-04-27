package model.pets;

import java.time.LocalDate;

public class Dog extends Pet{

    public Dog(String name, String commands, LocalDate birthday, Type type) {
        super(name, commands, birthday, type);
    }
}
