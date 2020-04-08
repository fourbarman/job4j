package ru.job4j.lambda.attachmentsort;

/**
 * Attachment.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 08.04.2020.
 */
public class Attachment {
    private String name;
    private int size;

    /**
     * Constructor.
     */
    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * Returns name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns size.
     *
     * @return size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns toString.
     *
     * @return string.
     */
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
