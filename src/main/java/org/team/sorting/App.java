package org.team.sorting;

import org.team.sorting.io.input.*;
import org.team.sorting.io.validation.BookValidator;
import org.team.sorting.model.Book;
import org.team.sorting.util.ConsoleUtils;

import java.util.List;
import java.util.Scanner;

public class App {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1) Загрузить книги");
            System.out.println("2) Выход");
            System.out.print("> ");
            String cmd = SC.nextLine().trim();
            switch (cmd) {
                case "1" -> {
                    List<Book> books = fillData();
                    if (!books.isEmpty()) {
                        System.out.println("Пример первых записей:");
                        books.stream().limit(5).forEach(System.out::println);
                    }
                }
                case "2" -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Неизвестная команда");
            }
        }
    }

    private static List<Book> fillData() {
        System.out.println("Как загрузить данные?");
        System.out.println("1) Из файла  2) Рандом  3) Вручную");
        System.out.print("> ");
        String way = SC.nextLine().trim();

        InputStrategy<Book> strategy;
        switch (way) {
            case "1" -> {
                System.out.print("Путь к файлу (например src/main/resources/sample-books.txt): ");
                String path = SC.nextLine().trim();
                strategy = new FileInputStrategy(path, new BookValidator());
            }
            case "2" -> {
                System.out.print("Сколько записей сгенерировать? ");
                int n = ConsoleUtils.safeInt(SC);
                strategy = new RandomInputStrategy(n, new BookValidator());
            }
            case "3" -> {
                System.out.print("Сколько записей создать вручную? ");
                int n = ConsoleUtils.safeInt(SC);
                strategy = new ManualInputStrategy(n, new BookValidator(), SC);
            }
            default -> {
                System.out.println("Отмена.");
                return List.of();
            }
        }

        InputResult<Book> result = strategy.load();
        result.getWarnings().forEach(w -> System.out.println("[WARN] " + w));
        result.getErrors().forEach(e -> System.out.println("[ERROR] " + e));
        if (!result.isSuccess() && result.getData().isEmpty()) {
            System.out.println("Данные не загружены.");
            return List.of();
        }
        System.out.println("Загружено записей: " + result.getData().size());
        return result.getData();
    }
}
