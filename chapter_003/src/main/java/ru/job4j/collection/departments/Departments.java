package ru.job4j.collection.departments;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        TreeSet<String> tmp = new TreeSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start == "") {
                    tmp.add(el);
                    start = el;
                } else {
                    tmp.add(start + "/" + el);
                    start = start + "/" + el;
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }
    public static void sortDesc(List<String> orgs) {
        List<List<String>> result = new ArrayList<>();
        int index = 0;
        while (index < orgs.size()) {
            if (orgs.get(index).length() == orgs.get(0).length()) {
                int end = index;
                while (end < orgs.size()) {
                    if (orgs.get(end).startsWith(orgs.get(index))) {
                        end++;
                    } else {
                        break;
                    }
                }
                result.add(orgs.subList(index, end));
            }
            index++;
        }

        List<String> lst = result.get(result.size() - 1);
        int i = result.size() - 2;
        while (i >= 0) {
            lst.addAll(result.get(i));
            i--;
        }
        orgs = lst;
        System.out.println(orgs);
    }
}
