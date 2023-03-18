package ca.bcit.comp1510.lab08;

import java.util.Scanner;
/**
 * Showing date.
 * @author SoheeHwang
 * @version 2023
 */

public class Date {
    
    /** day of month.  1.... 12 */
    private int day;
    
    
    /** month of year.  1 ..... 12 */
    private int month;
    
    /** year in Gregorian calendar.  1001 .... 2999 */
    private int year;
    
    /** the day , the month, the year.
     * 
     * @param theDay.
     * @param theMonth same.
     * @param theYear same.
     */
     
    public Date(int theDay, int theMonth, int theYear) {
        if (!isDateValid(theDay, theMonth, theYear)) {
            throw new IllegalArgumentException("Invalid date");
        }
        day = theDay;
        month = theMonth;
        year = theYear;

    }
    
    /** About Month.
     * 
     * @param month same.
     * @return same.
     */
    public static boolean isMonthValid(int month) {
        final int twlv = 12;
        return month >= 1 && month <= twlv;
    }
    
    /** About Year.
     * 
     * @param year same.
     * @return same.
     */
    public static boolean isYearValid(int year) {
        final int lowerYr = 1582;
        final int higherYr = 2999;
        return year >= lowerYr && year <= higherYr;
    }
    
    /** About Leapyear.
     * 
     * @param year same.
     * @return same.
     */
    public static boolean isLeapYear(int year) {
        final int four = 4;
        final int hundred = 100;
        final int fourHund = 400;
        return (year % four == 0 && year % hundred != 0) 
                || (year % fourHund == 0);
    }

    
    /** About dayinmonth.
     * 
     * @param month same.
     * @param isLeapYear same.
     * @return dayinmonth.
     */
    public static int daysInMonth(int month, boolean isLeapYear) {
        final int apr = 4;
        final int jun = 6;
        final int sept = 9;
        final int nov = 11;
        final int twentyEight = 28;
        final int twentyNine = 29;
        final int thirty = 30;
        final int thirtyOne = 31;
        switch (month) {
            case 2:
                return isLeapYear ? twentyNine : twentyEight;
            case apr:
            case jun:
            case sept:
            case nov:
                return thirty;
            default:
                return thirtyOne;
        }
    }

   
    /** about DateValid.
     * 
     * @param day same.
     * @param month same.
     * @param year same.
     * @return true or false.
     */
    public static boolean isDateValid(int day, int month, int year) {
        if (!isYearValid(year)) {
            return false;
        }
        if (!isMonthValid(month)) {
            return false;
        }
        int maxDays = daysInMonth(month, isLeapYear(year));
        if (day < 1 
                || day > maxDays) {
            return false;
        }
        return true;
    }

    
    /** Drives the programs.
     * 
     * @param args unused.
     */
    public static void main(String[] args) { 
        //date read in from user
        int month; 
        int day; 
        int year;
        //true if parts of input from user is valid
        boolean monthValid;
        boolean yearValid;
        boolean dayValid;  
        //number of days in month read in
        int daysInMonth;
        //true if user's year is a leap year
        boolean leapYear;
        
        Scanner scan = new Scanner(System.in);
        //Get integer month, day, and year from user
        System.out.print("Enter month (1-12): ");
        month = scan.nextInt();
        System.out.print("Enter day (1-31): ");
        day = scan.nextInt();
        System.out.print("Enter year (1582-2999): ");
        year = scan.nextInt();
        //Use the methods to check to see if month is valid
        monthValid = isMonthValid(month);
        //Use the methods to check to see if year is valid
        yearValid = isYearValid(year);
        //Use the methods to determine whether it's a leap year
        leapYear = isLeapYear(year);
        //Use the methods to determine number of days in month
        daysInMonth = daysInMonth(month, leapYear);
        //Use the methods to see if day is valid
        dayValid = isDateValid(day, month, year);
        //Use the methods to determine whether date is valid
        boolean dateValid = isDateValid(day, month, year);
        //   and print appropriate message
        if (dateValid) {
            System.out.println("The date " + month + "/" 
                    + day + "/" + year + " is valid.");
        } else {
            System.out.println("The date " + month + "/" 
                    + day + "/" + year + " is not valid.");
            Date date = new Date(year, month, day);
      
        }
        scan.close();
    } 
}
