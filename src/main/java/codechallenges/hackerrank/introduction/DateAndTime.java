/*
 * Copyright © 2018, All Rights Reserved
 *
 * DateAndTime.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Apr 08, 2018		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.introduction;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-date-and-time
 *
 * @author Venkaiah Chowdary Koneru
 */
public class DateAndTime {

    public static String getDay(String day, String month, String year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));

        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }
}
