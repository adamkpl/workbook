package workbook;

import java.util.ArrayList;

public class ReverseString {
    public static void main(String[] args) {
        // Take input - a single String
        String input = "kawa";

        // Reverse and Print
        System.out.println(reverseString(input));

        // Take input - a list of Strings.
        ArrayList<String> strings = new ArrayList<>();
        strings.add("10");
        strings.add("adam");
        strings.add("Kayak");

        // Reverse and Print
        reverseAndPrintStrings(strings);

    }

    private static String reverseString(String s) {
        s = new StringBuilder(s).reverse().toString();
        return s;
    }

    private static void reverseAndPrintStrings(ArrayList<String> s) {
        for (String reversedString:s) {
            reversedString = new StringBuilder(reversedString).reverse().toString();
            System.out.println(reversedString);
        }
    }

}
