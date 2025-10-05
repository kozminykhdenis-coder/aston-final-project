import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private final int year;
    private final String genre;
    private final int pages;
    private final double price;

    private Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.isbn = builder.isbn;
        this.year = builder.year;
        this.genre = builder.genre;
        this.pages = builder.pages;
        this.price = builder.price;
    }

    // Геттеры
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }
    public int getPages() { return pages; }
    public double getPrice() { return price; }

    // Builder класс
    public static class Builder {
        private String title;
        private String author;
        private String isbn;
        private int year;
        private String genre;
        private int pages;
        private double price;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && 
               pages == book.pages && 
               Double.compare(book.price, price) == 0 && 
               Objects.equals(title, book.title) && 
               Objects.equals(author, book.author) && 
               Objects.equals(isbn, book.isbn) && 
               Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, isbn, year, genre, pages, price);
    }

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', isbn='%s', year=%d, genre='%s', pages=%d, price=%.2f}",
                title, author, isbn, year, genre, pages, price);
    }
}