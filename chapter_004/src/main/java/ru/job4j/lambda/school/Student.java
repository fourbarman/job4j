package ru.job4j.lambda.school;


/**
 * Student.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 14.04.2020.
 */
public class Student {
    private String name;
    private String surname;
    private int score;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Student(String surname, String name, int score) {
        this.surname = surname;
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

}
