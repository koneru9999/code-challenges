package codechallenges.codewars;

/**
 * Create a method named "rotate" that returns a given array with the elements inside the array rotated n spaces.<br>
 * If n is greater than 0 it should rotate the array to the right. If n is less than 0 it should rotate the array to
 * the left. If n is 0, then it should return the array unchanged.<br>
 * <p>
 * Example:
 * Object[] data = new Object[]{1, 2, 3, 4, 5};<br>
 * rotate(data, 1)    =>    {5, 1, 2, 3, 4}<br>
 * rotate(data, 2)    =>    {4, 5, 1, 2, 3}<br>
 * rotate(data, 3)    =>    {3, 4, 5, 1, 2}<br>
 * rotate(data, 4)    =>    {2, 3, 4, 5, 1}<br>
 * rotate(data, 5)    =>    {1, 2, 3, 4, 5}<br>
 * rotate(data, 0)    =>    {1, 2, 3, 4, 5}<br>
 * rotate(data, -1)    =>    {2, 3, 4, 5, 1}<br>
 * rotate(data, -2)    =>    {3, 4, 5, 1, 2}<br>
 * rotate(data, -3)    =>    {4, 5, 1, 2, 3}<br>
 * rotate(data, -4)    =>    {5, 1, 2, 3, 4}<br>
 * rotate(data, -5)    =>    {1, 2, 3, 4, 5}<br>
 * Furthermore the method should take ANY array of objects and perform this operation on them:<br>
 * rotate(new Object[]{'a', 'b', 'c'}, 1)        =>    {'c', 'a', 'b'}<br>
 * rotate(new Object[]{1.0, 2.0, 3.0}, 1)        =>    {3.0, 1.0, 2.0}<br>
 * rotate(new Object[]{true, true, false}, 1)    =>    {false, true, true}<br>
 * </p>
 * Finally the rotation shouldn't be limited by the indices available in the array. Meaning that if we exceed the indices of the array it keeps rotating.
 * <p>Example:
 * Object[] data = new Object[]{1, 2, 3, 4, 5}<br>
 * rotate(data, 7)        =>    {4, 5, 1, 2, 3}<br>
 * rotate(data, 11)       =>    {5, 1, 2, 3, 4}<br>
 * rotate(data, 12478)    =>    {3, 4, 5, 1, 2}<br>
 * </p>
 */
public class Rotator {

    public static Object[] rotate(Object[] data, int rBy) {
        int length = data.length;
        int localRby = rBy % length;
        Object[] ret = new Object[length];

        for (int i = 0; i < length; i++) {
            int j = i + localRby;
            if (j > length - 1) {
                j = j % length;
            } else if (j < 0) {
                j = j + length;
            }
            ret[j] = data[i];
        }

        return ret;
    }

    public static void main(String[] args) {
        Object[] data = new Integer[]{1, 2, 3, 4, 5};
        print(rotate(data, 1)); // {4, 5, 1, 2, 3}
        print(rotate(data, 2)); // {4, 5, 1, 2, 3}
        print(rotate(data, 3)); // {3, 4, 5, 1, 2}
        print(rotate(data, 4)); // {2, 3, 4, 5, 1}
        print(rotate(data, 5)); // {1, 2, 3, 4, 5}
        print(rotate(data, 0)); // {1, 2, 3, 4, 5}
        print(rotate(data, -1)); // {2, 3, 4, 5, 1}
        print(rotate(data, -2)); // {3, 4, 5, 1, 2}
        print(rotate(data, -3)); // {4, 5, 1, 2, 3}
        print(rotate(data, -4)); // {5, 1, 2, 3, 4}
        print(rotate(data, -5)); // {1, 2, 3, 4, 5}

        print(rotate(data, 12478)); // {3, 4, 5, 1, 2}

    }

    private static void print(Object[] arr) {
        for (Object obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.print("\n");
    }
}
