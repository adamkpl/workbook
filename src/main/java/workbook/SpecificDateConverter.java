package workbook;

import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SpecificDateConverter {
    public static void main(String[] args) {

        ArrayList<String> hours = new ArrayList();
        hours.add("10.00.00");
        hours.add("01.00.00");
        hours.add("00.10.00");
        hours.add("00.01.00");
        hours.add("00.00.10");
        hours.add("00.00.01");

        ArrayList<String> expectedHours = new ArrayList();
        expectedHours.add("10.00.00");
        expectedHours.add("1.00.00");
        expectedHours.add("10.00");
        expectedHours.add("1.00");
        expectedHours.add("10");
        expectedHours.add("1");

        // Assert
        for (int i = 0; i < hours.size(); i++) {
            System.out.println("Input: " + hours.get(i) + ", expected: '" + expectedHours.get(i) + "', actual: " + stripDate(hours.get(i)));
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

        date = date.replaceAll("[.]", "");

        date = stripFirstZero(date);

        String hh;
        String mm;
        String ss;

        //todo must be better solution to this
        if (date.length()==6) {
            // if 6 chars then hh.mm.ss

        } else if (date.length()==5) {
            // if 5 chars then h.mm.ss

        } else if (date.length()==4) {
            // if 4 chars then mm.ss

        } else if (date.length()==3) {
            // if 3 chars then m.ss

        } else if (date.length()==2) {
            // if 2 chars then ss

        } else if (date.length()==1) {
            // if 1 char then s

        } else if (date.length()==0) {
            // if 0 char then ''
        }


        return date;
    }

    private static String stripFirstZero(String DDMMHH) {
        System.out.print("stripZero DDMMHH " + DDMMHH + " "); //todo remove this
        for (int i = 0; i < 6; i++) {
            if (stripFirstDot(DDMMHH.substring(0,1)).equals("0")) {
                DDMMHH = DDMMHH.replaceFirst("[0]", "");
            } else {
                System.out.print("");
            }
        }

        return DDMMHH;
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

