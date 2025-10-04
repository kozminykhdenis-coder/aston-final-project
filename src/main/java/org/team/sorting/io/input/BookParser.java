package org.team.sorting.io.input;

import org.team.sorting.model.Book;
import java.util.Optional;

public final class BookParser {
    private BookParser() {}

    public static Optional<Book> parse(String line) {
        if (line == null || line.isBlank())
            return Optional.empty();

        String[] p = line.split(";");
        if (p.length != 3) return Optional.empty();
        try {
            String title = p[0].trim();
            int year = Integer.parseInt(p[1].trim());
            int pages = Integer.parseInt(p[2].trim());
            return Optional.of(Book.builder().title(title).year(year).pages(pages).build());
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
