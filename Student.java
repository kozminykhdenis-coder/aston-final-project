import java.util.Objects;

public class Student {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String group;
    private final double averageGrade;
    private final int yearOfStudy;

    private Student(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.group = builder.group;
        this.averageGrade = builder.averageGrade;
        this.yearOfStudy = builder.yearOfStudy;
    }

    // Геттеры
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getGroup() { return group; }
    public double getAverageGrade() { return averageGrade; }
    public int getYearOfStudy() { return yearOfStudy; }

    // Builder класс
    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String group;
        private double averageGrade;
        private int yearOfStudy;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder group(String group) {
            this.group = group;
            return this;
        }

        public Builder averageGrade(double averageGrade) {
            this.averageGrade = averageGrade;
            return this;
        }

        public Builder yearOfStudy(int yearOfStudy) {
            this.yearOfStudy = yearOfStudy;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && 
               Double.compare(student.averageGrade, averageGrade) == 0 && 
               yearOfStudy == student.yearOfStudy && 
               Objects.equals(firstName, student.firstName) && 
               Objects.equals(lastName, student.lastName) && 
               Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, group, averageGrade, yearOfStudy);
    }

    @Override
    public String toString() {
        return String.format("Student{firstName='%s', lastName='%s', age=%d, group='%s', averageGrade=%.2f, yearOfStudy=%d}",
                firstName, lastName, age, group, averageGrade, yearOfStudy);
    }
}