package org.team.sorting.io.input;

import org.team.sorting.io.validation.Validator;
import org.team.sorting.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInputStrategy implements InputStrategy<Book> {
    private final int count;
    private final Validator<Book> validator;
    private static final String[] TITLES = {
            "Clean Code","Algorithms","Design Patterns","Java Concurrency","Effective Java",
            "Kotlin in Action","Spring in Action","Refactoring","DDD","CS Basics"
    };
    private static final Random RND = new Random();

    public RandomInputStrategy(int count, Validator<Book> validator) {
        this.count = Math.max(0, count);
        this.validator = validator;
    }

    @Override
    public InputResult<Book> load() {
        InputResult<Book> res = new InputResult<>();
        if (count <= 0)
            return res.error("Число записей должно быть > 0");

        List<Book> data = new ArrayList<>(count);
        int bad = 0;
        for (int i = 0; i < count; i++) {
            String title = TITLES[RND.nextInt(TITLES.length)] + " #" + (RND.nextInt(900)+100);
            int year = 1980 + RND.nextInt(45);
            int pages = 50 + RND.nextInt(950);
            Book b = Book.builder().title(title).year(year).pages(pages).build();
            var errs = validator.validate(b);
            if (errs.isEmpty()) data.add(b); else bad++;
        }
        if (data.isEmpty())
            res.error("Сгенерированные данные не прошли валидацию.");
        if (bad > 0)
            res.warn("Отфильтровано записей: " + bad);
        return res.addData(data);
    }
}
