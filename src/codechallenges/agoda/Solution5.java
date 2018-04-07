package codechallenges.agoda;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * convert old URL to new URL format
 * <p>
 * Old URL format: /th-th/some/path/to/page.html
 * new URL format: /some/path/to/page.html?lang=th-th
 * <p>
 * if no lang code in the URL, use en-us.
 *
 * @author Venkaiah Chowdary Koneru
 */
public class Solution5 {

    /* Implement this method. You can add other methods if you want */
    static String FormatNewURL(String url) {

        int secondSlashIndex = url.indexOf("/", 1);

        if (secondSlashIndex > 0) {
            String langCode = url.substring(1, secondSlashIndex);

            String newURL = url.substring(secondSlashIndex);

            if (!newURL.contains("?")) {
                newURL += "?";
            } else {
                newURL += "&";
            }

            return newURL + "lang=" + langCode;
        } else {
            return "/?lang=en-us";
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _url;
        try {
            _url = in.nextLine();
        } catch (Exception e) {
            _url = null;
        }
        res = FormatNewURL("/th-th/some/path/to/page.html");
        bw.write(res);
        bw.newLine();

        bw.close();
    }
}
