package model.pets;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import model.AnimalGenerality;

public class Hamster implements Serializable, AnimalGenerality<Hamster> {
    private int id;
    private String name;
    private String commands;
    private LocalDate birthday;

    public Hamster(int id, String name, String songs, LocalDate birthday) {
        id = -1;
        this.name = name;
        this.commands = songs;
        this.birthday = birthday;
    }

    public Hamster(String name, String songs, LocalDate birthday)
    {
        this(name, songs, birthday);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongs() {
        return commands;
    }

    public void setSongs(String songs) {
        this.commands = songs;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge(){
        return getPeriod(this.birthday, LocalDate.now());
    }

    public int getPeriod(LocalDate date1, LocalDate date2){
        Period diff = Period.between(date1, date2);
        return diff.getYears();
    }
    public String getInfo()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(". Издаваемые звуки: ");
        sb.append(commands);
        sb.append(". Дата рождения: ");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = formatter.format(birthday);
        sb.append(strDate);
        return sb.toString();
    }
}
