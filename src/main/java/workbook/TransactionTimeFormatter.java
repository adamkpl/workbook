package workbook;

import org.junit.Assert;

import java.util.ArrayList;

public class TransactionTimeFormatter {
    public static void main(String[] args) {

        ArrayList<String> hours = new ArrayList();
        hours.add("10.00.00");
        hours.add("01.00.00");
        hours.add("00.10.00");
        hours.add("00.01.00");
        hours.add("00.00.10");
        hours.add("00.00.01");
        hours.add("00.00.00");
        hours.add("24.00.00");

        ArrayList<String> expectedHours = new ArrayList();
        expectedHours.add("10.00.00");
        expectedHours.add("1.00.00");
        expectedHours.add("10.00");
        expectedHours.add("1.00");
        expectedHours.add("10");
        expectedHours.add("1");
        expectedHours.add("");
        expectedHours.add("24.00.00");

        // Assert
        for (int i = 0; i < hours.size(); i++) {
            System.out.println("Input: " + hours.get(i) + ", expected: '" + expectedHours.get(i)
                    + "', actual: '" + stripHourOfTransactionFromLeadingZeroesAndDots(hours.get(i)) + "'");
            Assert.assertEquals(expectedHours.get(i), stripHourOfTransactionFromLeadingZeroesAndDots(hours.get(i)));
        }
    }

    private static String stripHourOfTransactionFromLeadingZeroesAndDots(String hour) {
        return replaceLeadingZeroesAndDots(hour);
    }

    private static String replaceFirstZero(String DDMMHH) {
        if (DDMMHH.charAt(0) == '0') {
            DDMMHH = DDMMHH.replaceFirst("[0]", "");
        } //else {
//            System.out.print("");
//        }

        return DDMMHH;
    }

    private static String replaceFirstDot(String DDMMHH) {
        if (DDMMHH.charAt(0) == '.') {
            DDMMHH = DDMMHH.replaceFirst("[.]", "");
        } //else {
//            System.out.print("");
//        }

        return DDMMHH;
    }

    private static String replaceLeadingZeroesAndDots(String DDMMHH) {
        for (int i = 0; i < 6; i++) {
            DDMMHH = replaceFirstDot(DDMMHH);
            DDMMHH = replaceFirstZero(DDMMHH);
        }

        return DDMMHH;
    }

}
