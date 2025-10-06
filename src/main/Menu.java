package main;

import java.util.Scanner;
import java.util.Comparator;
public class Menu {
    private Scanner scanner;
    private Application app;

    public Menu(Application app) {
        this.scanner = new Scanner(System.in);
        this.app = app;
    }

    public void showMainMenu() {
        while(true) {
            System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
            System.out.println("1. Загрузить данные");
            System.out.println("2. Отсортировать данные");
            System.out.println("3. Найти элемент");
            System.out.println("4. Показать данные");
            System.out.println("5. Запустить тесты");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    showDataLoadMenu();
                    break;
                case 2:
                    showSortMenu();
                    break;
                case 3:
                    showSearchMenu();
                    break;
                case 4:
                    app.displayData();
                    break;
                case 5:
                    runTests();
                    break;
                case 0:
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    private void showDataLoadMenu() {
        System.out.println("\n=== ЗАГРУЗКА ДАННЫХ ===");
        System.out.println("1. Из файла");
        System.out.println("2. Случайные данные");
        System.out.println("3. Ручной ввод");
        System.out.print("Выберите опцию: ");

        int choice = getIntInput();
        System.out.println("Введите количество элементов: ");
        int size = getIntInput();

        app.LoadData(choice, size);
    }

    private void showSortMenu() {
        System.out.println("\n=== СОРТИРОВКА ===");
        System.out.println("1. По полю 1 (имя)");
        System.out.println("2. По полю 2 (возраст)");
        System.out.println("3. По полю 3 (оценка)");
        System.out.print("Выберите поле для сортировки: ");

        int choice = getIntInput();
        app.sortData(choice);
    }

    private void showSearchMenu() {
        System.out.println("\n=== ПОИСК ===");
        System.out.println("1. По полю 1 (имя)");
        System.out.println("2. По полю 2 (возраст)");
        System.out.println("3. По полю 3 (оценка)");
        System.out.print("Выберите поле для поиска: ");

        int field = getIntInput();
        System.out.print("Введите значение для поиска: ");
        String value = scanner.nextLine();

        app.searchData(field, value);
    }

    private void runTests() {
        System.out.println("\n=== ЗАПУСК ТЕСТОВ ===");
        TestRunner testRunner = new TestRunner();
        testRunner.runAllTests();
    }

    private int getIntInput() {
        while(true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число: ");
            }
        }
    }
}
