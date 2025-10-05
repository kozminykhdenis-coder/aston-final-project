import java.util.Objects;

public class Product {
    private final String name;
    private final String category;
    private final double price;
    private final int quantity;
    private final double rating;
    private final String manufacturer;

    private Product(Builder builder) {
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.rating = builder.rating;
        this.manufacturer = builder.manufacturer;
    }

    // Геттеры
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getRating() { return rating; }
    public String getManufacturer() { return manufacturer; }

    // Builder класс
    public static class Builder {
        private String name;
        private String category;
        private double price;
        private int quantity;
        private double rating;
        private String manufacturer;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder rating(double rating) {
            this.rating = rating;
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && 
               quantity == product.quantity && 
               Double.compare(product.rating, rating) == 0 && 
               Objects.equals(name, product.name) && 
               Objects.equals(category, product.category) && 
               Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price, quantity, rating, manufacturer);
    }

    @Override
    public String toString() {
        return String.format("Product{name='%s', category='%s', price=%.2f, quantity=%d, rating=%.1f, manufacturer='%s'}",
                name, category, price, quantity, rating, manufacturer);
    }
}