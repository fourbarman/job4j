package ru.job4j.lambda.attachmentsort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * AttachmentSort.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 08.04.2020.
 */
public class AttachmentSort {
    /**
     * Main method.
     * Sorts attachments by size, than by name.
     */
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getSize() - o2.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> nameComparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        attachments.sort(nameComparator);
        System.out.println(attachments);
    }
}
