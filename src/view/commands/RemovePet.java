package view.commands;

import view.ConsoleUI;

public class RemovePet extends Command {

    public RemovePet(ConsoleUI consoleUI){
        super("Удалить питомца", consoleUI);
    }

    public void execute() {
        getConsoleUI().removePet();
    }
}
