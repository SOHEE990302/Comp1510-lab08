package ca.bcit.comp1510.lab08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Date class.
 * 
 * @author Sohee Hwang
 * @version 2023
 */
public class DateTest {
    private DateTest test;
    
    @BeforeEach
    public void setUp() throws Exception {
       test = new DateTest();
    }

    @Test
    public void testValidDate() {
        Date date = new Date(1, 1, 2000);
        assertEquals(date.isDateValid(1, 1, 2000), true);
    }
    
    @Test
    public void testInvalidDate() throws Exception{
        Exception excep = assertThrows(IllegalArgumentException.class, () -> {
            new Date(2, 30, 2001);
        });
        
        assertTrue(excep.getMessage().contains("Invalid date"));
    }
    @Test
    public void testIsMonthValid() {
        assertTrue(Date.isMonthValid(1));
        assertTrue(Date.isMonthValid(12));
        assertFalse(Date.isMonthValid(0));
        assertFalse(Date.isMonthValid(13));
    }
    
    @Test
    public void testIsYearValid() {
        assertTrue(Date.isYearValid(1582));
        assertTrue(Date.isYearValid(2999));
        assertFalse(Date.isYearValid(1000));
        assertFalse(Date.isYearValid(3000));
    }
    
    @Test
    public void testIsLeapYear() {
        assertTrue(Date.isLeapYear(2000));
        assertTrue(Date.isLeapYear(2020));
        assertFalse(Date.isLeapYear(1900));
        assertFalse(Date.isLeapYear(2022));
    }
    
    @Test
    public void testDaysInMonth() {
        assertEquals(31, Date.daysInMonth(1, false));
        assertEquals(28, Date.daysInMonth(2, false));
        assertEquals(29, Date.daysInMonth(2, true));
        assertEquals(31, Date.daysInMonth(3, false));
        assertEquals(30, Date.daysInMonth(4, false));
        assertEquals(31, Date.daysInMonth(5, false));
        assertEquals(30, Date.daysInMonth(6, false));
        assertEquals(31, Date.daysInMonth(7, false));
        assertEquals(31, Date.daysInMonth(8, false));
        assertEquals(30, Date.daysInMonth(9, false));
        assertEquals(31, Date.daysInMonth(10, false));
        assertEquals(30, Date.daysInMonth(11, false));
        assertEquals(31, Date.daysInMonth(12, false));
    }
    
    @Test
    public void testIsDateValid() {
        assertTrue(Date.isDateValid(1, 1, 2000));
        assertTrue(Date.isDateValid(29, 2, 2000));
        assertFalse(Date.isDateValid(30, 2, 2000));
        assertFalse(Date.isDateValid(29, 2, 1900));
        assertTrue(Date.isDateValid(31, 12, 2021));
        assertFalse(Date.isDateValid(32, 1, 2022));
        assertFalse(Date.isDateValid(31, 13, 2023));
        assertFalse(Date.isDateValid(31, 13, 3000));
        assertFalse(Date.isDateValid(-1, 12, 2000));
    }
    
 
}