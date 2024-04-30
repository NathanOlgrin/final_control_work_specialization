package view.commands;

import view.ConsoleUI;

public class SaveAnimalList extends Command {

    public SaveAnimalList(ConsoleUI consoleUI){
        super("Сохранить список животных", consoleUI);
    }

    public void execute() {
        getConsoleUI().saveList();
    }
}
