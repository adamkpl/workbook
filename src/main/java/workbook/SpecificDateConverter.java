package workbook;

import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SpecificDateConverter {
    public static void main(String[] args) {

        ArrayList<String> hours = new ArrayList();
        hours.add("11.11.11");
        hours.add("01.11.11");
        hours.add("00.11.11");
        hours.add("00.01.11");
        hours.add("00.00.11");
        hours.add("00.00.01");
        hours.add("00.00.00");
        hours.add("10.00.00");
        hours.add("11.00.00");
        hours.add("00.10.00");
        hours.add("00.00.10");

        ArrayList<String> expectedHours = new ArrayList();
        expectedHours.add("11.11.11");
        expectedHours.add("1.11.11");
        expectedHours.add("11.11");
        expectedHours.add("1.11");
        expectedHours.add("11");
        expectedHours.add("1");
        expectedHours.add("");
        expectedHours.add("10.00.00");
        expectedHours.add("11.00.00");
        expectedHours.add("10.00");
        expectedHours.add("10");

        // Assert
        for (int i = 0; i < hours.size(); i++) {
            System.out.println("Input: " + hours.get(i) + ", expected: " + stripDate(hours.get(i)));
            //Assert.assertEquals(expectedHours.get(i), stripDate(hours.get(i)));  //todo uncomment
        }

    }

    private static String stripDate(String date) {
        // trim whitespace
        date = date.trim();

        // Verify if parsable as Date, otherwise it should not work.
        SimpleDateFormat sdf = new SimpleDateFormat("hh.mm.ss");
        try {
            Date dateParsed = sdf.parse(date);
        } catch (ParseException e) {
            System.out.println("Invalid input. Date not parsable.");
        }

        // Split

        // 1. HH
        String hh = date.substring(0, 2);
        hh = stripZero(hh);

        // 2. MM
        String mm = date.substring(3, 5);
        mm = stripZero(mm);

        // 3. SS
        String ss = date.substring(6, 8);
        ss = stripZero(ss);

        // Concat final
        String final_date = hh + "." + mm + "." + ss;

        // if . is the first char then remove it.
        final_date = stripFirstDot(final_date);

        return final_date;
    }

    private static String stripZero(String ii) {
        if (ii.startsWith("00")) {
            ii = ii.replaceAll("[0]", "");
        } else if (ii.charAt(0) == '0' && ii.charAt(1) != '0') {
            // replace first 0; leave index 1 as is
            ii = ii.replaceFirst("[0]", "");
        }

        return ii;
    }

    private static String stripFirstDot(String final_date) {
        for (int i = 0; i < 2; i++) {
            if (final_date.startsWith(".")) {
                final_date = final_date.replaceFirst(".", "");
            }
        }

        return final_date;
    }

}

