package ru.job4j.collection.lexsort;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    /**
     * Compare.
     * Return int < 0 if String left is less than String right.
     * Return int > 0 if String left is greater than String right.
     * Return int = 0 if String left is equal String right.
     * @param left String.
     * @param right String.
     * @return int.
     */
    @Override
    public int compare(String left, String right) {
        String leftString = getStringNumbers(toStr(left));
        String rightString = getStringNumbers(toStr(right));
        return leftString.compareTo(rightString);
    }

    /**
     * Makes string from String array.
     * @param str Array of Strings.
     * @return String.
     */
    public String getStringNumbers(String[] str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (isNumber(str[i])) {
                final String s = str[i];
                sb.append(s);
            }
        }
        return sb.toString();
    }

    /**
     * Returns if String contains int number.
     * @param str String
     * @return Result.
     */
    public boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * Returns String[] without '.' splitter.
     * @param s String
     * @return String[]
     */
    public String[] toStr(String s) {
        return s.split("\\.");
    }
}
