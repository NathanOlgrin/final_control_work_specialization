package view.commands;

import view.ConsoleUI;

public class GetInfo extends Command {

    public GetInfo(ConsoleUI consoleUI){
        super("Информация о имеющихся домашних животных.", consoleUI);
    }

    public void execute() {
        getConsoleUI().getInfoList();
    }
}
