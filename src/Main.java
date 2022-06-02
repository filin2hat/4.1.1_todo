import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true) {
            printMenu();
            String input = scanner.nextLine();
            if (input.equals("0")) {
                System.out.println("Пока!");
                break;
            }
            switch (input) {
                case "1":
                    addTask(list, scanner);
                    break;
                case "2":
                    printList(list);
                    break;
                case "3":
                    removeTask(list, scanner);
                    break;
                default:
                    System.out.println("!Не верный ввод номера задачи!");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите действие:\n" +
                "1. Добавить задачу.\n" +
                "2. Вывести список задач.\n" +
                "3. Удалить задачу.\n" +
                "0. Выход.\n");
    }

    public static void addTask(List<String> list, Scanner scanner) throws RuntimeException {
        System.out.println("\nВведите задачу для планирования:");
        try {
            String task = scanner.nextLine();
            list.add(task);
            System.out.println();
        } catch (RuntimeException e) {
            System.out.println("Неправильный формат ввода. \n");
        }
    }

    public static void printList(List<String> list) {
        System.out.println("\nСписок задач:");
        if (list.isEmpty()) {
            System.out.println("Список задач пуст!\n");
        }
        for (int i = 0; i < list.size(); i++) {
            String task = list.get(i);
            System.out.println((i + 1) + ". " + task);
        }
//        for (Iterator<String> it = list.iterator(); it.hasNext() ;) {
//            String task = it.next();
//            System.out.println((list.indexOf(task) + 1) + ". " + task);
//        }
//        for (String task : list) {
//            System.out.println((list.indexOf(task) + 1) + ". " + task);
//        }
        System.out.println();
    }

    public static void removeTask(List<String> list, Scanner scanner) throws RuntimeException {
        while (true) try {
            System.out.println("Выберете номер задачи для удаления. '0' - для отмены.");
            for (String task : list) {
                System.out.println((list.indexOf(task) + 1) + ". " + task);
            }
            String task = scanner.nextLine();
            if (task.equals("0")) {
                break;
            }
            if (list.isEmpty()) {
                System.out.println("Список задач пуст!\n");
                break;
            }
            list.remove(Integer.parseInt(task) - 1);
        } catch (RuntimeException e) {
            System.out.println("Неправильный формат ввода, Повторите ввод:\n");
        }
    }
}
