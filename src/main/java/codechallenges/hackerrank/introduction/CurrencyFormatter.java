/*
 * Copyright © 2018, All Rights Reserved
 *
 * CurrencyFormatter.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Apr 08, 2018		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.introduction;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-currency-formatter
 *
 * @author Venkaiah Chowdary Koneru
 */
public class CurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        Locale india = new Locale("en", "IN");

        System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment));
        System.out.println("India: " + NumberFormat.getCurrencyInstance(india).format(payment));
        System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
        System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));
    }
}
