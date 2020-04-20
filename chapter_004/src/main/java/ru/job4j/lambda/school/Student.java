package ru.job4j.lambda.school;


/**
 * Student.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 14.04.2020.
 */
public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private int score;
    private int scope;

    public Student(String surname, String name, int score, int scope) {
        this.surname = surname;
        this.name = name;
        this.score = score;
        this.scope = scope;
    }

    public int getScope() {
        return scope;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        return this.getScope() - o.getScope();
    }
}
