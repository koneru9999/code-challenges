package codechallenges.agoda;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * convert old URL to new URL format
 * <p>
 * Old URL format: /th-th/some/path/to/page.html
 * New URL format: /some/path/to/page.html?lang=th-th
 * </p>
 * <p>
 * Old URL format: /th-th/some/path/to/page.html?key=val&key2=val
 * New URL format: /some/path/to/page.html?lang=th-th&key=val&key2=val
 * </p>
 * <p>
 * Old URL format: /some/path/to/page.html
 * New URL format: /some/path/to/page.html?lang=en-us
 * </p>
 * <p>
 * Old URL format: /some/path/to/page.html?key=val&key2=val
 * New URL format: /some/path/to/page.html?lang=en-us&key=val&key2=val
 * </p>
 * if no lang code in the URL, use en-us.
 *
 * @author Venkaiah Chowdary Koneru
 */
public class Solution5 {

    /* Implement this method. You can add other methods if you want */
    static String FormatNewURL(String url) {
        Pattern pattern = Pattern.compile("^/([a-z]{2}-[a-z]{2})(/.*)(\\?(.*))$");
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            return matcher.replaceAll("$2?lang=$1&$4");
        } else {
            return url + (url.contains("?") ? "&lang=en-us" : "?lang=en-us");
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
        res = FormatNewURL(_url);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

    /*static String FormatNewURL(String url) {

        String[] urlParts = null;
        if (url.contains("?")) {
            urlParts = url.split("\\?", 1);
        } else {
            urlParts = new String[]{url};
        }

        String[] uri = urlParts[0].split("/");

        String lang = "en-us";
        StringBuilder sb = new StringBuilder();
        if (uri.length > 0) {
            int i = 1;
            if (uri[1].length() == 5
                    && uri[1].contains("-")) {
                lang = uri[1];
                i++;
            }

            while (i < uri.length) {
                sb.append("/").append(uri[i]);
                i++;
            }
        } else {
            sb.append("/");
        }


        sb.append("?").append("lang=").append(lang);

        if (urlParts.length > 1) {
            sb.append(urlParts[1]);
        }
        return sb.toString();
    }*/
}
