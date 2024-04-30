package view;

import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{

    private Scanner scanner;
    private Presenter presenter;

    private boolean check;

    private MainMenu menu;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        check = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветствие");
        while (check){
            printMenu();
            check = choice();
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }
    private boolean choice() {
        String choiceStr = scanner.nextLine();
        int choice = Integer.parseInt(choiceStr);

        if(choice > 0 && choice < menu.size()+1){
            menu.execute(choice);
        }

        if (choice == menu.size()){
            return false;
        } else {
            return true;
        }
    }
    public void addAnimal(){
        System.out.println("Введите тип животного: 1 - собака, 2 - кот, 3 - хомяк. ");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите комадны животного: ");
        String commands = scanner.nextLine();
        System.out.println("Введите год рождения:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц рождения:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день рождения:");
        int day = Integer.parseInt(scanner.nextLine());
        presenter.addPet(choice, name, commands, LocalDate.of(year, month, day));
    }

    public void removePet(){
        System.out.println("Введите id животного, которого хотите удалить: ");
        int choice = Integer.parseInt(scanner.nextLine());
        presenter.removePet(choice);
    }

    public void getInfoList(){
        System.out.println(presenter.getInfoList());
    }

    public void saveList(){
        presenter.saveList();
    }
    public void loadAnimalList(){
        presenter.loadList();
    }
    public void getCommands(){
        System.out.println("Введите id животного, команды которого хотите вывести на экран: ");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println(presenter.getCommands(choice));
    }
    public void addCommands(){
        System.out.println("Введите id животного, которому нужно добавить команды: ");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите комадны: ");
        String commands = scanner.nextLine();
        presenter.addCommands(choice, commands);
    }

}
