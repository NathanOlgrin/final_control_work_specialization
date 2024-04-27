package model.pets;

import java.time.LocalDate;

public class Cat extends Pet{

    public Cat(int id, String name, String commands, LocalDate birthday) {
        super(id, name, commands, birthday);
    }
}
