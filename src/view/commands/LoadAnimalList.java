package view.commands;

import view.ConsoleUI;

public class LoadAnimalList extends Command {
    public LoadAnimalList(ConsoleUI consoleUI){
        super("Загрузить список животных", consoleUI);
    }
    public void execute() {
        getConsoleUI().loadAnimalList();
    }
}
