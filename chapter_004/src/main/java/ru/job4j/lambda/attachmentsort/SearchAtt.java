package ru.job4j.lambda.attachmentsort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * SearchAtt.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 10.04.2020
 */
public class SearchAtt {
    /**
     * Filters list by size.
     *
     * @param list List of Attachment objects.
     * @return list.
     */
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> pred = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(list, pred);
    }

    /**
     * Filters list by name.
     *
     * @param list List of Attachment objects.
     * @return list.
     */
    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> pred = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, pred);
    }

    /**
     * Filters list by size or name.
     *
     * @param list List of Attachment objects.
     * @return list.
     */
    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> pred) {
        List<Attachment> result = new ArrayList<Attachment>();
        for (Attachment att : list) {
            if (pred.test(att)) {
                result.add(att);
            }
        }
        return result;
    }
}
