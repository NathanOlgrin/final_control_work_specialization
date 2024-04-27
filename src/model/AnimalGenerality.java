package model;

import java.io.Serializable;
import java.time.LocalDate;

public interface AnimalGenerality<T> extends Serializable {
    void setId(int id);
    int getId();
    int getAge();
    String getName();
    LocalDate getBirthday();
    String getInfo();
    String getCommands();
}
