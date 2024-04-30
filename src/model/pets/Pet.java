package model.pets;

import model.animals_list.AnimalGenerality;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;


public abstract class Pet implements Serializable, AnimalGenerality<Dog> {
    private int id;
    private String name;
    private String commands;
    private LocalDate birthday;
    private Type type;

    public Pet(String name, String commands, LocalDate birthday, Type type) {
        id = -1;
        this.name = name;
        this.commands = commands;
        this.birthday = birthday;
        this.type = type;
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

    public String getCommands() {
        return commands;
    }

    public void setCommands(String songs) {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setAddCommands(String add_commands){
        StringBuilder sb = new StringBuilder();
        sb.append(this.commands);
        sb.append(", ");
        sb. append(add_commands);
        this.name = sb.toString();
    }
    public String getInfo()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(". Вид: ");
        sb.append(type);
        sb.append(". Издаваемые звуки: ");
        sb.append(commands);
        sb.append(". Дата рождения: ");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = formatter.format(birthday);
        sb.append(strDate);
        return sb.toString();
    }
}
