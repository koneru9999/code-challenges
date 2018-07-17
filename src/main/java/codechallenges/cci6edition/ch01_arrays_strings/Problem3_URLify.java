package codechallenges.cci6edition.ch01_arrays_strings;

/**
 * <b>URLify:</b> Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: if implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 *
 * @author Venkaiah Chowdary Koneru
 */
public class Problem3_URLify {

    /**
     * Time Complexity: O(2n)
     * Space Complexity: O(1)
     */
    public static String urlify(String input, int trueLength) {
        char[] inputArr = input.toCharArray();

        int spacesCount = 0;
        int index = 0;

        for (int i = 0; i < trueLength; i++) {
            if (inputArr[i] == ' ') {
                spacesCount++;
            }
        }

        index = trueLength + spacesCount * 2;
        if (trueLength < inputArr.length) {
            inputArr[trueLength] = '\0';
        }

        for (int i = trueLength - 1; i >= 0; i--) {
            if (inputArr[i] == ' ') {
                inputArr[index - 1] = '0';
                inputArr[index - 2] = '2';
                inputArr[index - 3] = '%';
                index = index - 3;
            } else {
                inputArr[index - 1] = inputArr[i];
                index--;
            }
        }

        return new String(inputArr);
    }

    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith    ", 13)); //Mr%20John%20Smith
        System.out.println(urlify(" John Smith    ", 11)); //%20John%20Smith
    }
}
