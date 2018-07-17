package codechallenges.cci6edition.ch01_arrays_strings;

/**
 * Ch: Arrays And Strings
 * Problem 1.8
 *
 * <b>Zero Matrix:</b> Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 */
public class Problem8_ZeroMatrix {

    /**
     * Time Complexity: O(n)
     */
    public static void setZeros(int[][] matrix) {
        boolean row[] = new boolean[matrix.length];
        boolean column[] = new boolean[matrix[0].length];

        // Store the row and column index values with 0
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < column.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        // Nullify Columns
        for (int j = 0; j < column.length; j++) {
            if (column[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

}
