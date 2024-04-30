package view.commands;

import view.ConsoleUI;

public class GetCommand extends Command {

    public GetCommand(ConsoleUI consoleUI){
        super("Вывести список команд определенного животного", consoleUI);
    }
    public void execute() {
        getConsoleUI().getCommands();
    }
}
