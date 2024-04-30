package view.commands;

import view.ConsoleUI;

public class AddCommand extends Command {

    public AddCommand(ConsoleUI consoleUI){
        super("Добавить команды питомцу", consoleUI);
    }
    public void execute() {
        getConsoleUI().addCommands();
    }
}
