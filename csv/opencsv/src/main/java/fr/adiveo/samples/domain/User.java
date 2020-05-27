package fr.adiveo.samples.domain;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import java.util.StringJoiner;

/**
 * : Akram - 26/05/2020.
 */
public class User {
    @CsvBindByName(column = "firstname")
//    @CsvBindByPosition(position = 0)
    private String firstName;
    @CsvBindByName(column = "lastName")
//    @CsvBindByPosition(position = 1)
    private String lastName;
    @CsvBindByName(column = "age")
//    @CsvBindByPosition(position = 2)
    private int age;

    public User() {

    }

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("age=" + age)
                .toString();
    }
}
