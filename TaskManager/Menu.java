package TaskManager;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private TaskManager taskManager;
    private Scanner scanner;

    public Menu() {
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить задачу на сегодня");
            System.out.println("2. Добавить задачу на определенный день");
            System.out.println("3. Просмотр задач на сегодня");
            System.out.println("4. Просмотр задач на определенный день");
            System.out.println("5. Просмотр задач на неделю");
            System.out.println("6. Показать последние 5 просмотренных задач");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask(LocalDate.now());
                    break;
                case 2:
                    System.out.print("Введите дату задачи (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    addTask(date);
                    break;
                case 3:
                    displayTasksForDay(LocalDate.now());
                    break;
                case 4:
                    System.out.print("Введите дату (yyyy-mm-dd): ");
                    LocalDate specificDate = LocalDate.parse(scanner.nextLine());
                    displayTasksForDay(specificDate);
                    break;
                case 5:
                    System.out.print("Введите начальную дату недели (yyyy-mm-dd): ");
                    LocalDate startDate = LocalDate.parse(scanner.nextLine());
                    displayTasksForWeek(startDate);
                    break;
                case 6:
                    displayHistory();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }

    private void addTask(LocalDate date) {
        System.out.print("Введите заголовок задачи: ");
        String title = scanner.nextLine();
        System.out.print("Введите текст задачи: ");
        String text = scanner.nextLine();
        Task task = new Task(title, text, date);
        taskManager.addTask(task);
        System.out.println("Задача добавлена.");
    }

    private void displayTasksForDay(LocalDate date) {
        System.out.println("Задачи на " + date + ":");
        taskManager.getTasksForDay(date).forEach(System.out::println);
    }

    private void displayTasksForWeek(LocalDate startDate) {
        System.out.println("Задачи на неделю, начиная с " + startDate + ":");
        taskManager.getTasksForWeek(startDate).forEach(System.out::println);
    }

    private void displayHistory() {
        System.out.println("Последние 5 просмотренных задач:");
        taskManager.getHistory().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMenu();
    }
}

