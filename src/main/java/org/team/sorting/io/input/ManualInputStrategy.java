package org.team.sorting.io.input;

import org.team.sorting.io.validation.Validator;
import org.team.sorting.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualInputStrategy implements InputStrategy<Book> {
    private final int count;
    private final Validator<Book> validator;
    private final Scanner sc;

    public ManualInputStrategy(int count, Validator<Book> validator, Scanner sc) {
        this.count = Math.max(0, count);
        this.validator = validator;
        this.sc = sc;
    }

    @Override
    public InputResult<Book> load() {
        InputResult<Book> res = new InputResult<>();
        if (count <= 0)
            return res.error("Число записей должно быть > 0");

        List<Book> data = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            System.out.println("Книга #" + (i + 1));
            String title = askNonEmpty("title: ");
            int year = askInt("year: ");
            int pages = askInt("pages: ");

            Book b = Book.builder()
                    .title(title)
                    .year(year)
                    .pages(pages)
                    .build();
            var errs = validator.validate(b);
            if (errs.isEmpty()) {
                data.add(b);
            } else {
                System.out.println("Ошибки: " + String.join(", ", errs));
                i--; // повторяем ввод текущей записи
            }
        }
        return res.addData(data);
    }

    private String askNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String v = sc.nextLine().trim();
            if (!v.isBlank())
                return v;
            System.out.println("Пусто. Попробуйте ещё раз.");
        }
    }

    private int askInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String v = sc.nextLine().trim();
            try {
                return Integer.parseInt(v);
            } catch (NumberFormatException e) {
                System.out.println("Нужно целое число.");
            }
        }
    }
}
