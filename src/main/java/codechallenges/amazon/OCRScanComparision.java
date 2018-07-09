package codechallenges.amazon;

/**
 * You are given two passages of text that have been scanned and passed through OCR software.
 * (OCR stands for Optical Character Recognition, which is the conversion of printed text into machine-readable
 * strings.) Unfortunately, the scans were of poor quality and some letters were not recognized by the OCR software.
 * Write a program to check (based on the output from the OCR software) whether the two text sources might in fact be
 * the same.
 * <p>
 * We assume that each text passage consists only of English letters. The OCR output from each scan is
 * given as a string in which unrecognized letters are marked as follows. Firstly, let us mark each
 * unrecognized letter by “?“. For example, if the OCR software didn’t recognize the second and third letters
 * of the text “AppLe“, it would result in OCR output of “A??Le“. Then, for brevity, every group of
 * K consecutive “?” characters is replaced by the decimal representation of integer K (without leading zeros).
 * Thus, the above OCR result would be represented as “A2Le“. (For the sake of clarity, such numeric replacement
 * is performed on groups of “?” characters that cannot be extended either to the left or to the right.)
 * <p>
 * You are given two strings S and T consisting of N and M characters, respectively, and you would like
 * to check whether they might have been obtained as OCR scans of the same text. For example, both strings
 * “A2Le” and “2pL1” could have been obtained as scans of the word “AppLe” (but also as scans of the word “AmpLe“).
 * Both strings “a10” and “10a” could have been obtained as scans of the word “abbbbbbbbba”
 * (but also from many other strings of length 11, starting and ending with “a“).
 * <p>
 * On the other hand, strings “ba1” and “1Ad” could not have been obtained from the same text,
 * since the second letter of each text is different.
 * <p>
 * Write a function:
 * <p>
 * boolean solution(String S, String T);
 * <p>
 * that, given two strings S and T consisting of N and M characters, respectively, determines whether
 * strings S and T can be obtained as OCR output from the same text.
 * <p>
 * For example, given “A2Le” and “2pL1“, your function should return true, as explained above.
 * Given “a10” and “10a“, your function should return true, as explained above.
 * Given “ba1” and “1Ad“, your function should return false, as explained above.
 * Given “3x2x” and “8“, your function should return false, since they represent strings of different length.
 * <p>
 * Assume that:
 * <p>
 * N and M are integers within the range [1..100,000];
 * lengths of texts before the OCR process are integers within the range [1..100,000];
 * strings S and T consist only of alphanumerical characters (a-z and/or A-Z and/or 0-9);
 * strings S and T contain neither single zeros (e.g. “abc0abc“) nor integers with leading zeros (e.g. “abc012abc“).
 * <p>
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class OCRScanComparision {

    public static boolean solution(String S, String T) {
        if (S == null || T == null || S.length() != T.length()) {
            return false;
        }

        StringBuilder modifiedS = new StringBuilder();
        for (char c : S.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                modifiedS.append(String.valueOf(c));
            } else {
                modifiedS.append(new String(new char[c - '0']).replace('\0', '?'));
            }
        }

        StringBuilder modifiedT = new StringBuilder();
        for (char c : T.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                modifiedT.append(String.valueOf(c));
            } else {
                modifiedT.append(new String(new char[c - '0']).replace('\0', '?'));
            }
        }

        String replacedS = modifiedS.toString();
        String replacedT = modifiedT.toString();

        for (int i = 0; i < replacedS.length(); i++) {
            if (replacedS.charAt(i) != '?' && replacedT.charAt(i) != '?'
                    && replacedS.charAt(i) != replacedT.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("A2Le", "2pL1")); // true
        System.out.println(solution("a10", "10a")); // true
        System.out.println(solution("ba1", "1Ad")); // false
        System.out.println(solution("3x2x", "8")); // false
    }
}
