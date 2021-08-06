package workbook;

import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AddYearsToDate {
    public static void main(String[] args) throws ParseException {

        /*
        Input received from the system is always a static String in "dd/MM/yyyy" format e.g. 31/07/2000.
        Add 18-years to a date a given, and output a date as String in "dd.MM.yyyy" format e.g. 31.07.2018.
        */

        // Ask for a date in format DD/MM/YYYY as String
        //String userInput = askForDate();
        String userInput = "01/08/1986";
        System.out.println("User input (String): " + userInput);

        // Convert String to Date
        Date dateParsed = parseDate(userInput, "dd/MM/yyyy");
        System.out.println("User input parsed as Date (dd/MM/yyyy): " + dateParsed);

        // Add n-years
        Date newDate = addYearsToDate(dateParsed, 18);
        System.out.println("New date: " + newDate);

        String newDateConverted = convertNewDate(newDate, "dd.MM.yyyy");
        System.out.println("New date as String (dd.MM.yyyy): " + newDateConverted);

        Assert.assertEquals("01.08.2004", newDateConverted);

    }

    private static String askForDate() {
        //todo Exception handling when an invalid input received
        Scanner date = new Scanner(System.in);
        System.out.print("Date (DD/MM/YYYY): ");
        return date.nextLine();
    }

    private static Date parseDate(String dateToParse, String simpleDateFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
        return sdf.parse(dateToParse);
    }

    private static Date addYearsToDate(Date date, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    private static String convertNewDate(Date date, String simpleDateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(simpleDateFormat);
        return formatter.format(date);
    }

    // Stub
    @Deprecated
    private static void addEighteenYearsToToday() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(today);
        System.out.println(calendar.getTime());

        calendar.add(Calendar.YEAR, 18);
        System.out.println(calendar.getTime());
    }

}
