package org.team.sorting.io.validation;

import org.team.sorting.model.Book;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BookValidator implements Validator<Book> {
    @Override
    public List<String> validate(Book b) {
        List<String> errs = new ArrayList<>();

        if (b == null) {
            errs.add("book: null");
            return errs;
        }

        if (b.getTitle() == null || b.getTitle().isBlank()) {
            errs.add("title: пусто");
        }

        int thisYear = Year.now().getValue();
        if (b.getYear() < 1500 || b.getYear() > thisYear) {
            errs.add("year: вне диапазона [1500.." + thisYear + "]");
        }

        if (b.getPages() <= 0 || b.getPages() > 5000) {
            errs.add("pages: вне диапазона (1..5000)");
        }

        return errs;
    }
}
