package workbook;

import java.util.stream.IntStream;

/**
 * Palindromes.
 * I did not write this. I just modified it a little bit.
 * @since       2020-02-14
 * @author      Coding and Decoding
 * @see         <a href="https://www.instagram.com/p/B8Xxj1PgVnS/">codinganddecoding</a>
 */

public class Palindromes {
    public static void main(String[] args) {
        // todo read multiple strings (rows) from a file and check if palindromes

        // Method 1. While loop
        checkIfPalindromeWithWhileLoop("Civic");

        // Method 2. For loop
        checkIfPalindromeWithForLoop("Kayak");

        // Method 3. Reverse String
        checkIfPalindromeWithReverseString("Level");

        // Method 4. Stream
        checkIfPalindromeWithStreams("Madam");
    }

    private static void checkIfPalindromeWithWhileLoop(String palindromeString) {
        int left = 0;
        int right = palindromeString.length() - 1;
        palindromeString = palindromeString.toLowerCase();

        while (left < right)
            if (palindromeString.charAt(left++) != palindromeString.charAt(right--)) {
                System.out.println(palindromeString + " is NOT a palindrome.");
            }

        System.out.println(palindromeString + " is a palindrome.");
    }

    private static void checkIfPalindromeWithForLoop(String palindromeString) {
        palindromeString = palindromeString.toLowerCase();

        for (int i = 0; i < palindromeString.length() / 2; i++)
            if(palindromeString.charAt(i) != palindromeString.charAt(palindromeString.length() - 1 - i)) {
                System.out.println(palindromeString + " is NOT a palindrome.");
            }
        System.out.println(palindromeString + " is a palindrome.");
    }

    private static void checkIfPalindromeWithReverseString(String palindromeString) {
        palindromeString = palindromeString.toLowerCase();

        if (palindromeString.equals(new StringBuilder(palindromeString).reverse().toString())) {
            System.out.println(palindromeString + " is a palindrome.");
        } else {
            System.out.println(palindromeString + " is NOT a palindrome.");
        }
    }

    private static void checkIfPalindromeWithStreams(String palindromeString) {
        String palindromeStringLowerCase = palindromeString.toLowerCase();

        if (IntStream.range(0, palindromeStringLowerCase.length() / 2).
                noneMatch(i -> palindromeStringLowerCase.charAt(i) != palindromeStringLowerCase.charAt(palindromeStringLowerCase.length() - i - 1))) {
            System.out.println(palindromeString + " is a palindrome.");
        } else {
            System.out.println(palindromeString + " is NOT a palindrome.");
        }
    }

}