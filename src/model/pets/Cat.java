package model.pets;

import java.time.LocalDate;

public class Cat extends Pet{

    public Cat(String name, String commands, LocalDate birthday, Type type) {
        super(name, commands, birthday, type);
    }
}
