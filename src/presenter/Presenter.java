package presenter;

import model.service.Service;
import model.writer.FileHandler;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service(new FileHandler());
    }

    public void addPet(int choice, String name, String commands, LocalDate birthday){
        service.addPet(choice, name, commands, birthday);
    }

    public String getInfoList(){
        return service.getInfoList();
    }

    public void removePet(int id){
        service.remove(id);
    }

    public String getCommands(int id){
        return service.getCommands(id);
    }

    public boolean addCommands(int id, String commands){
        return service.addCommands(id, commands);
    }

    public void saveList(){
        service.saveList();
    }

    public void loadList(){
        service.loadSaveList();
    }

}
