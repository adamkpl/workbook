package workbook;

import java.util.ArrayList;

public class ReverseString {
    public static void main(String[] args) {
        // Take input - a single String
        String input = "kawa";
        System.out.println("input: " + input);

        // Reverse
        String inputReversed = reverseString(input);

        // and Print
        System.out.println("output: " + inputReversed);

        // Take input - a list of Strings.
        ArrayList<String> strings = new ArrayList<>();
        strings.add("10");
        strings.add("20");
        strings.add("30");
        System.out.println("strings: " + strings);

        // Reverse
        ArrayList<String> stringsReversed = reverseString(strings);

        // and Print
        System.out.println("stringsReversed: " + stringsReversed);

    }

    private static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static ArrayList<String> reverseString(ArrayList<String> s) {
        for (int i = 0; i < s.size(); i++) {
            s.set(i, reverseString(s.get(i)));
        }
        return s;
    }

}
