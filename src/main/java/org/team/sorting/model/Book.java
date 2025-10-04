package org.team.sorting.model;

import java.util.Objects;

public class Book {
    private final String title;
    private final int year;
    private final int pages;

    private Book(Builder b) {
        this.title = b.title;
        this.year = b.year;
        this.pages = b.pages;
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public int getPages() { return pages; }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + "'" +
                ", year=" + year +
                ", pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return year == book.year && pages == book.pages && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, pages);
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String title;
        private int year;
        private int pages;

        public Builder title(String title) { this.title = title; return this; }
        public Builder year(int year) { this.year = year; return this; }
        public Builder pages(int pages) { this.pages = pages; return this; }
        public Book build() { return new Book(this); }
    }
}
