package view.commands;

import view.ConsoleUI;

public class AddAnimal extends Command {

    public AddAnimal(ConsoleUI consoleUI){
        super("Добавление нового животного", consoleUI);
    }
    public void execute() {
        getConsoleUI().addAnimal();
    }
}
