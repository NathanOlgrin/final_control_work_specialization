package model.pets;

import java.time.LocalDate;

public class Hamster extends Pet{

    public Hamster(String name, String commands, LocalDate birthday, Type type) {
        super(name, commands, birthday, type);
    }
}
