package codechallenges.codewars;

/**
 * You need to return a string that displays a diamond shape on the screen using asterisk ("*") characters.
 * Please see provided test cases for exact output format.<br>
 * The shape that will be returned from print method resembles a diamond, where the number provided as input
 * represents the number of *’s printed on the middle line. The line above and below will be centered and will
 * have 2 less *’s than the middle line. This reduction by 2 *’s for each line continues until a line with a
 * single * is printed at the top and bottom of the figure.<br>
 * Return null if input is even number or negative (as it is not possible to print diamond with even number or negative number).
 *
 * @author Venkaiah Chowdary Koneru
 */
public class GiveMeADiamond {
    public static String print(int n) {
        if (n % 2 == 0 || n < 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int numberOfSpacesOnEachSide = n / 2 < i ? (i - (n / 2)) : ((n / 2) - i);

            for (int j = 0; j < n; j++) {
                if (j < numberOfSpacesOnEachSide || j > (n - numberOfSpacesOnEachSide) - 1) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(print(9));
        System.out.println(print(3));
        System.out.println(print(8)); // null

        System.out.println(print(-1)); // null
    }
}
