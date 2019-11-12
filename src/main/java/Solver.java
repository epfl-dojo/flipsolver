import java.util.*;

/**
 * FlipSolver.
 */

public class Solver {

    /**
     * Return the minimum number of indexes you have to flip to find the solution.
     *
     * @param values the game values.
     * @return the indexes you have to flip to find the solution.
     */
    public int[] solve(boolean[] values) {
        /*
            The algorithm tries all the possible solutions and chooses the one with the minimum answer.
            It tries all the possible combinations of the cells to be flipped in the first row.
            After flipping these cells we will have some another grid with different values than the
            one given in the input. For this grid, we iterate over the rows from the second to the last one.
            For each row, we iterate over the columns. For each column, we flip a cell if the cell above it
            has a value true. This guarantees  us that all cells in the above rows will be false after iterating
            over all the columns in the current row. After iterating over all the rows we check if the last row
            has all values of false, if yes, it means that this's a possible solution (because we already know
            that the cells above the last row have values false). Then, we compare all the possible solutions, and
            we chose the one with the minimum number of flips needed.
         */


        // find the length/width of the grid by finding the square root of number of elements
        int n = (int) Math.sqrt(values.length);

        // create an array of booleans that will be modified in the while flipping the cells
        boolean[] temp = new boolean[n * n];

        // cost variable represents the optimal solution found so far
        // maskAns variable represents the mask of the optimal solution found so far
        int maskAns = 0, cost = 36, tempCost;

        // try all possible combinations of the cells to be flipped from  the first all
        // a combination of cells indexes is called a mask
        for (int mask = 0; mask < (1 << n); mask++) {
            // initialize array temp to have the same values as the given input
            System.arraycopy(values, 0, temp, 0, n * n);

            // play a game according to the current mask
            tempCost = play(temp, n, mask, cost);

            // save the mask if it leads to a correct solution (all cells are false) with a
            // less number of cells to be flipped
            if (cost > tempCost && check(temp, n)) {
                maskAns = mask;
                cost = tempCost;
            }
        }

        // create an array of integers to be returned
        int ret[] = new int[cost];

        // repeat the steps of playing a game for a specific mask but with saving the indexes of flipped cells in array ret
        int index = 0;
        System.arraycopy(values, 0, temp, 0, n * n);
        for (int j = 0; j < n; j++) {
            if ((maskAns & (1 << j)) > 0) {
                flip(temp, j, n);
                ret[index] = j;
                index++;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[((i - 1) * n) + j]) {
                    flip(temp, (i * n) + j, n);
                    ret[index] = (i * n) + j;
                    index++;
                }
            }
        }

        // return the answer
        return ret;
    }

    /**
     * @param values  the game values
     * @param n       the length/width of the square grid
     * @param mask    the combination of indexes from the first row to be flipped
     * @param curCost the optimal solution found so far
     * @return number of cells needed to be flipped
     */
    private int play(boolean[] values, int n, int mask, int curCost) {
        // number of cells needed to be flipped for the given arguments
        int cost = 0;

        // flip the cells of the first row according to the give mask
        // break if the cost of this mask became more or equal to the optimal solution found so far
        for (int j = 0; curCost >= cost && j < n; j++) {
            // flip the index j if it exists in the given mask
            if ((mask & (1 << j)) > 0) {
                flip(values, j, n);
                // increase number of flips needed
                cost++;
            }
        }

        // iterate over all cells between second and last row, and between first and last column
        // break if the cost of this mask became more or equal to the optimal solution found so far
        for (int i = 1; curCost >= cost && i < n; i++) {

            for (int j = 0; curCost >= cost && j < n; j++) {
                // flip the cell if the value of the cell above it is true
                if (values[((i - 1) * n) + j]) {
                    // flip the cell in row i and column j (its index is ((i*n) + j))
                    flip(values, (i * n) + j, n);
                    // increase number of flips needed
                    cost++;
                }
            }
        }

        // return the number of cells needed to be flipped
        return cost;
    }

    /**
     * Check if all the cells in the last row of the grid are false
     *
     * @return true if all cells are false
     */
    private boolean check(boolean[] values, int n) {
        for (int i = 0; i < n; i++) {
            // return false if at least one cell has a value true
            if (values[(n * (n - 1)) + i])
                return false;
        }
        return true;
    }

    /**
     * In the given matrix, flip the value at the given index, and at the neighbours' indexes
     * (up, down, left and right).
     *
     * @param matrix the matrix.
     * @param index  the index.
     * @param cols   the number of columns.
     */
    public void flip(boolean[] matrix, int index, int cols) {
        // first flip the index itself
        matrix[index] = !matrix[index];

        // next its neighbours
        int[] neighbours = MatrixUtil.neighbours4(matrix.length, index, cols);

        for (int neighbourIndex : neighbours) {
            matrix[neighbourIndex] = !matrix[neighbourIndex];
        }
    }

    /**
     * Returns random, unique ints in the given range (inclusive).
     *
     * @param min minimum value.
     * @param max maximum value.
     * @return random, unique ints in the given range (inclusive).
     */
    public static int[] randomIntegers(int min, int max, int num) {
        List<Integer> list = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        int[] result = new int[num];

        for (int i = 0; i < num; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}