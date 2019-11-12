import java.util.*;

/**
 * MatrixUtil.
 */
public class MatrixUtil
{
    /**
     * Return the indexes that are on the given side ("left" or "right") on the X axis of the
     * given matrix.
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     * @param side the side on the X axis, "left" or "right".
     *
     * @return the indexes that are on the given side ("left" or "right") on the X axis of the matrix.
     */
    public static int[] indexesX(int rows, int cols, String side)
    {
        if (cols % 2 == 0)
        {
            return indexesXeven(rows, cols, side);
        }
        else
        {
            return indexesXodd(rows, cols, side);
        }
    }

    /**
     * Return the values that are on the given side ("left" or "right") on the X axis of the
     * given matrix.
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     * @param side the side on the X axis, "left" or "right".
     *
     * @return the values that are on the given side ("left" or "right") on the X axis of the matrix.
     */
    public static int[] valuesX(int[] matrix, int rows, int cols, String side)
    {
        int[] indexes = indexesX(rows, cols, side);

        int[] values = new int[indexes.length];

        for (int i = 0; i < values.length; i++)
        {
            values[i] = matrix[indexes[i]];
        }

        return values;
    }

    /**
     * Return the indexes that are on the given side ("left" or "right") on the X axis of the
     * given matrix.
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     * @param side the side on the X axis, "left" or "right".
     *
     * @return the indexes that are on the given side ("left" or "right") on the X axis of the matrix.
     */
    private static int[] indexesXeven(int rows, int cols, String side)
    {
        // the number of columns on one side
        int sideCols = cols / 2;

        // the indexes for the wanted side
        int[] result = new int[rows * sideCols];

        int index = 0;
        int counter = 0;

        // rows
        for (int row = 0; row < rows; row++)
        {
            // cols
            for (int col = 0; col < cols; col++)
            {
                if (
                        (side.equals("left") && col < sideCols) ||
                                (side.equals("right") && col > sideCols - 1))

                {
                    result[index] = counter;

                    index++;
                }

                counter++;
            }
        }

        return result;
    }

    /**
     * Return the indexes that are on the given side ("left" or "right") on the X axis of the
     * given matrix.
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     * @param side the side on the X axis, "left" or "right".
     *
     * @return the indexes that are on the given side ("left" or "right") on the X axis of the matrix.
     */
    public static int[] indexesXodd(int rows, int cols, String side)
    {
        // the number of columns on one side
        int sideCols = (cols - 1) / 2;

        // the middle column
        int middleCol = (cols - 1) / 2;

        // the indexes for the wanted side
        int[] result = new int[rows * sideCols];

        int index = 0;
        int counter = 0;

        // rows
        for (int row = 0; row < rows; row++)
        {
            // cols
            for (int col = 0; col < cols; col++)
            {
                if (
                        (side.equals("left") && col < middleCol) ||
                                (side.equals("right") && col > middleCol))

                {
                    result[index] = counter;

                    index++;
                }

                counter++;
            }
        }

        return result;
    }

    /**
     * Return the indexes that are on the given side ("up" or "down") on the Y axis of the
     * given matrix.
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     * @param side the side on the Y axis, "up" or "down".
     *
     * @return the indexes that are on the given side ("up" or "down") on the Y axis of the matrix.
     */
    public static int[] indexesY(int rows, int cols, String side)
    {
        if (rows % 2 == 0)
        {
            return indexesYeven(rows, cols, side);
        }
        else
        {
            return indexesYodd(rows, cols, side);
        }
    }

    /**
     * Return the values that are on the given side ("up" or "down") on the Y axis of the
     * given matrix.
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     * @param side the side on the Y axis, "up" or "down".
     *
     * @return the values that are on the given side ("up" or "down") on the Y axis of the matrix.
     */
    public static int[] valuesY(int[] matrix, int rows, int cols, String side)
    {
        int[] indexes = indexesY(rows, cols, side);

        int[] values = new int[indexes.length];

        for (int i = 0; i < values.length; i++)
        {
            values[i] = matrix[indexes[i]];
        }

        return values;
    }

    /**
     * Return the indexes that are on the given side ("up" or "down") on the Y axis of the
     * given matrix.
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     * @param side the side on the Y axis, "up" or "down".
     *
     * @return the indexes that are on the given side ("up" or "down") on the Y axis of the matrix.
     */
    private static int[] indexesYeven(int rows, int cols, String side)
    {
        // the number of rows on one side
        int sideRows = rows / 2;

        // the indexes for the wanted side
        int[] result = new int[sideRows * cols];

        int index = 0;
        int counter = 0;

        // rows
        for (int row = 0; row < rows; row++)
        {
            // cols
            for (int col = 0; col < cols; col++)
            {
                if (
                        (side.equals("up") && row < sideRows) ||
                                (side.equals("down") && row > sideRows - 1))

                {
                    result[index] = counter;

                    index++;
                }

                counter++;
            }
        }

        return result;
    }

    /**
     * Return the indexes that are on the given side ("up" or "down") on the Y axis of the
     * given matrix.
     *
     * @param rows the number of rows.
     * @param cols the number of columns.
     * @param side the side on the Y axis, "up" or "down".
     *
     * @return the indexes that are on the given side ("up" or "down") on the Y axis of the matrix.
     */
    private static int[] indexesYodd(int rows, int cols, String side)
    {
        // the number of rows on one side
        int sideRows = (rows - 1) / 2;

        // the middle row
        int middleRow = (rows - 1) / 2;

        // the indexes for the wanted side
        int[] result = new int[sideRows * cols];

        int index = 0;
        int counter = 0;

        // rows
        for (int row = 0; row < rows; row++)
        {
            // cols
            for (int col = 0; col < cols; col++)
            {
                if (
                        (side.equals("up") && row < middleRow) ||
                                (side.equals("down") && row > middleRow))

                {
                    result[index] = counter;

                    index++;
                }

                counter++;
            }
        }

        return result;
    }

    /**
     * Return the index at the given position.
     *
     * @param row  the row number.
     * @param col  the column number.
     * @param cols the number of columns.
     *
     * @return the index at the given position.
     */
    public static int index(int row, int col, int cols)
    {
        return (row * cols - 1) + col + 1;
    }

    /**
     * Return the neighbours indexes of the given index in 4 directions (up, right, down and left)
     * in a map, the key is the direction name (e.g. "up"), the value is the index.
     *
     * @param size  the matrix size.
     * @param index the index.
     * @param cols  the number of columns.
     */
    public static Map<String, Integer> neighbours4Map(int size, int index, int cols)
    {
        Map<String, Integer> neighbours = new HashMap<>();

        // up
        int up = up(index, cols);

        if (up > -1)
        {
            neighbours.put("up", up);
        }

        // right
        int right = right(index, cols);

        if (right > -1)
        {
            neighbours.put("right", right);
        }

        // down
        int down = down(size, index, cols);

        if (down > -1)
        {
            neighbours.put("down", down);
        }

        // left
        int left = left(index, cols);

        if (left > -1)
        {
            neighbours.put("left", left);
        }

        return neighbours;
    }

    /**
     * Return the neighbours indexes of the given index in 8 directions (up, up_right, up_left, right,
     * down, down_right, down_left and left) in a map, the key is the direction name (e.g. "up"),
     * the value is the index.
     *
     * @param size  the matrix size.
     * @param index the index.
     * @param cols  the number of columns.
     */
    public static Map<String, Integer> neighbours8Map(int size, int index, int cols)
    {
        // we use the neighbours4 data and complete it
        Map<String, Integer> neighbours = neighbours4Map(size, index, cols);

        // up right
        int upRight = upRight(index, cols);

        if (upRight > -1)
        {
            neighbours.put("up_right", upRight);
        }

        // up left
        int upLeft = upLeft(index, cols);

        if (upLeft > -1)
        {
            neighbours.put("up_left", upLeft);
        }

        // down right
        int downRight = downRight(size, index, cols);

        if (downRight > -1)
        {
            neighbours.put("down_right", downRight);
        }

        // down left
        int downLeft = downLeft(size, index, cols);

        if (downLeft > -1)
        {
            neighbours.put("down_left", downLeft);
        }

        return neighbours;
    }

    /**
     * Return the neighbours indexes of the given index in 4 directions (up, right, down and left).
     *
     * @param size  the matrix size.
     * @param index the index.
     * @param cols  the number of columns.
     */
    public static int[] neighbours4(int size, int index, int cols)
    {
        List<Integer> neighbours = new ArrayList<>();

        // up
        int up = up(index, cols);

        if (up > -1)
        {
            neighbours.add(up);
        }

        // right
        int right = right(index, cols);

        if (right > -1)
        {
            neighbours.add(right);
        }

        // down
        int down = down(size, index, cols);

        if (down > -1)
        {
            neighbours.add(down);
        }

        // left
        int left = left(index, cols);

        if (left > -1)
        {
            neighbours.add(left);
        }

        int[] result = ArrayUtil.toIntArray(neighbours);

        Arrays.sort(result);

        return result;
    }

    /**
     * Return the neighbours indexes of the given index in 8 directions (up, up_right, up_left, right,
     * down, down_right, down_left and left).
     *
     * @param size  the matrix size.
     * @param index the index.
     * @param cols  the number of columns.
     */
    public static int[] neighbours8(int size, int index, int cols)
    {
        List<Integer> neighbours = new ArrayList<>();

        // up
        int up = up(index, cols);

        if (up > -1)
        {
            neighbours.add(up);
        }

        // up right
        int upRight = upRight(index, cols);

        if (upRight > -1)
        {
            neighbours.add(upRight);
        }

        // up left
        int upLeft = upLeft(index, cols);

        if (upLeft > -1)
        {
            neighbours.add(upLeft);
        }

        // right
        int right = right(index, cols);

        if (right > -1)
        {
            neighbours.add(right);
        }

        // down
        int down = down(size, index, cols);

        if (down > -1)
        {
            neighbours.add(down);
        }

        // down right
        int downRight = downRight(size, index, cols);

        if (downRight > -1)
        {
            neighbours.add(downRight);
        }

        // down left
        int downLeft = downLeft(size, index, cols);

        if (downLeft > -1)
        {
            neighbours.add(downLeft);
        }

        // left
        int left = left(index, cols);

        if (left > -1)
        {
            neighbours.add(left);
        }

        int[] result = ArrayUtil.toIntArray(neighbours);

        Arrays.sort(result);

        return result;
    }

    /**
     * Return the index up of the given index.
     *
     * @param index the index.
     * @param cols  the number of columns.
     *
     * @return the index up of the given index.
     */
    public static int up(int index, int cols)
    {
        int up = index - cols;

        if (up < 0)
        {
            return -1;
        }

        return up;
    }

    /**
     * Return the index up right of the given index.
     *
     * @param index the index.
     * @param cols  the number of columns.
     *
     * @return the index up right of the given index.
     */
    public static int upRight(int index, int cols)
    {
        int up = up(index, cols);

        if (up == -1)
        {
            return -1;
        }

        return right(up, cols);
    }

    /**
     * Return the index up left of the given index.
     *
     * @param index the index.
     * @param cols  the number of columns.
     *
     * @return the index up left of the given index.
     */
    public static int upLeft(int index, int cols)
    {
        int up = up(index, cols);

        if (up == -1)
        {
            return -1;
        }

        return left(up, cols);
    }

    /**
     * Return the index right of the given index.
     *
     * @param index the index.
     * @param cols  the number of columns.
     *
     * @return the index right of the given index.
     */
    public static int right(int index, int cols)
    {
        int right = index + 1;

        // check if we are back on the first column
        if (right % cols == 0)
        {
            return -1;
        }

        return right;
    }

    /**
     * Return the index down of the given index.
     *
     * @param size  the matrix size.
     * @param index the index.
     * @param cols  the number of columns.
     *
     * @return the index down of the given index.
     */
    public static int down(int size, int index, int cols)
    {
        int down = index + cols;

        if (down > size - 1)
        {
            return -1;
        }

        return down;
    }

    /**
     * Return the index down right of the given index.
     *
     * @param index the index.
     * @param cols  the number of columns.
     *
     * @return the index down right of the given index.
     */
    public static int downRight(int size, int index, int cols)
    {
        int down = down(size, index, cols);

        if (down == -1)
        {
            return -1;
        }

        return right(down, cols);
    }

    /**
     * Return the index down right of the given index.
     *
     * @param index the index.
     * @param cols  the number of columns.
     *
     * @return the index down right of the given index.
     */
    public static int downLeft(int size, int index, int cols)
    {
        int down = down(size, index, cols);

        if (down == -1)
        {
            return -1;
        }

        return left(down, cols);
    }

    /**
     * Return the index left of the given index.
     *
     * @param index the index.
     * @param cols  the number of columns.
     *
     * @return the index left of the given index.
     */
    public static int left(int index, int cols)
    {
        // check if we are on the first column
        if (index == 0 || index % cols == 0)
        {
            return -1;
        }

        return index - 1;
    }

    /**
     * Returns true if the given value is contiguous in the given matrix.
     *
     * @param matrix the matrix.
     * @param value  the value.
     *
     * @return true if the given value is contiguous in the given matrix.
     */
    public static boolean isContiguous(int[] matrix, int value)
    {
        int count = count(matrix, value);

        // special case, if we don't have the value we return false
        if (count == 0)
        {
            return false;
        }

        // special case, if we have only one element of a value we consider it contiguous
        if (count == 1)
        {
            return true;
        }

        // the number of columns
        int cols = (int) Math.sqrt(matrix.length);

        for (int i = 0; i < matrix.length; i++)
        {
            int element = matrix[i];

            // not the value we are checking
            if (element != value)
            {
                continue;
            }

            // check if we have at least one neighbour having the same value
            boolean found = false;

            int[] neighbours = neighbours4(matrix.length, i, cols);

            for (int neighbour : neighbours)
            {
                if (matrix[neighbour] == value)
                {
                    found = true;

                    break;
                }
            }

            // no neighbours having the same value found, it's not contiguous
            if (!found)
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns true if the matrix has the given value.
     *
     * @param matrix the matrix.
     * @param value  the value.
     *
     * @return true if the matrix has the given value.
     */
    public static boolean hasValue(int[] matrix, int value)
    {
        for (int i : matrix)
        {
            if (i == value)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the indexes that have the given value.
     *
     * @param matrix the matrix.
     * @param value  the value.
     *
     * @return the indexes that have the given value.
     */
    public static int[] withValue(int[] matrix, int value)
    {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[i] == value)
            {
                list.add(i);
            }
        }

        return ArrayUtil.toIntArray(list);
    }

    /**
     * Replace the given value.
     *
     * @param from the value from.
     * @param to   the value to.
     */
    public static void replace(int[] matrix, int from, int to)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[i] == from)
            {
                matrix[i] = to;
            }
        }
    }

    /**
     * Returns the number of indexes having the given value.
     *
     * @param matrix the matrix.
     * @param value  the value to count.
     *
     * @return the number of indexes having the given value.
     */
    public static int count(int[] matrix, int value)
    {
        int count = 0;

        for (int i : matrix)
        {
            if (value == i)
            {
                count++;
            }
        }

        return count;
    }

    /**
     * Returns the number of indexes having the given value.
     *
     * @param matrix the matrix.
     * @param value  the value to count.
     *
     * @return the number of indexes having the given value.
     */
    public static int count(String[] matrix, String value)
    {
        int count = 0;

        for (String element : matrix)
        {
            if (value.equals(element))
            {
                count++;
            }
        }

        return count;
    }

    /**
     * Returns the matrix index of the first element having the given value.
     *
     * @param matrix the matrix.
     * @param value  the value.
     *
     * @return the index.
     */
    public static int first(int[] matrix, int value)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[i] == value)
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns the empty indexes (where value = 0) in the given matrix.
     *
     * @param matrix the matrix.
     *
     * @return the available indexes.
     */
    public static int[] contiguousForIndex(int[] matrix, int index)
    {
        int[] empty = emptyForIndex(matrix, index);

        int[] copy = new int[matrix.length];

        System.arraycopy(matrix, 0, copy, 0, matrix.length);

        List<Integer> contiguous = new ArrayList<>();

        for (int i : empty)
        {
            copy[i] = index;

            if (isContiguous(copy, 0))
            {
                contiguous.add(i);
            }

            copy[i] = 0;
        }

        return ArrayUtil.toIntArray(contiguous);
    }

    /**
     * Returns the dominant value in the given matrix.
     *
     * @param matrix the matrix.
     *
     * @return the dominant value in the given matrix.
     */
    public static int dominant(int[] matrix)
    {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i : matrix)
        {
            Integer count = counts.get(i);

            if (count == null)
            {
                count = 0;
            }

            count++;

            counts.put(i, count);
        }

        int maxValue = 0;
        int maxCount = 0;

        for (Integer value : counts.keySet())
        {
            int count = counts.get(value);

            if (count > maxCount)
            {
                maxCount = count;
                maxValue = value;
            }
        }

        return maxValue;
    }

    /**
     * Returns the dominant value in the given matrix.
     *
     * @param matrix the matrix.
     *
     * @return the dominant value in the given matrix.
     */
    public static String dominant(String[] matrix)
    {
        Map<String, Integer> counts = new HashMap<>();

        for (String element : matrix)
        {
            Integer count = counts.get(element);

            if (count == null)
            {
                count = 0;
            }

            count++;

            counts.put(element, count);
        }

        String maxValue = "";
        int maxCount = 0;

        for (String element : counts.keySet())
        {
            int count = counts.get(element);

            if (count > maxCount)
            {
                maxCount = count;
                maxValue = element;
            }
        }

        return maxValue;
    }

    /**
     * Returns the empty indexes (where value = 0) in the given matrix.
     *
     * @param matrix the matrix.
     *
     * @return the available indexes.
     */
    public static int[] contiguousForValue(int[] matrix, int value)
    {
        int[] empty = emptyForValue(matrix, value);

        int[] copy = new int[matrix.length];

        System.arraycopy(matrix, 0, copy, 0, matrix.length);

        List<Integer> contiguous = new ArrayList<>();

        for (int i : empty)
        {
            copy[i] = value;

            if (isContiguous(copy, 0))
            {
                contiguous.add(i);
            }

            copy[i] = 0;
        }

        return ArrayUtil.toIntArray(contiguous);
    }

    /**
     * Returns the empty indexes (where value = 0) in the given matrix for the given value.
     *
     * @param matrix the matrix.
     * @param value  the value.
     *
     * @return the available indexes.
     */
    public static int[] emptyForValue(int[] matrix, int value)
    {
        // first find where we already have block
        List<Integer> occupied = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[i] == value)
            {
                occupied.add(i);
            }
        }

        // next add all the available indexes for these
        // blocks, we use a Set to remove duplicates
        Set<Integer> free = new HashSet<>();

        for (int i : occupied)
        {
            int[] available = emptyForIndex(matrix, i);

            for (int a : available)
            {
                free.add(a);
            }
        }

        // finally transform the Set into an array
        int[] result = new int[free.size()];

        int i = 0;

        for (Integer integer : free)
        {
            result[i] = integer;

            i++;
        }

        return result;
    }

    /**
     * Returns the empty indexes (where value = 0) in the given matrix at the given index.
     *
     * @param matrix the matrix.
     * @param index  the index.
     *
     * @return the available indexes.
     */
    public static int[] emptyForIndex(int[] matrix, int index)
    {
        int size = matrix.length;

        int cols = (int) Math.round(Math.sqrt(size));

        List<Integer> empty = new ArrayList<>();

        // top
        int top = index - cols;

        if (top > 0 && matrix[top] == 0)
        {
            empty.add(top);
        }

        // right
        int right = index + 1;

        if (right % cols > 0 && matrix[right] == 0)
        {
            empty.add(right);
        }

        // bottom
        int bottom = index + cols;

        if (bottom < size && matrix[bottom] == 0)
        {
            empty.add(bottom);
        }

        // left
        int left = index - 1;

        if (index % cols > 0 && matrix[left] == 0)
        {
            empty.add(left);
        }

        return ArrayUtil.toIntArray(empty);
    }

    /**
     * Prints the given matrix that has the same number of rows and cols.
     *
     * @param matrix the matrix that has the same number of rows and cols.
     */
    public static void print(int[] matrix)
    {
        print(ArrayUtil.toStringArray(matrix));
    }

    /**
     * Prints the given matrix that has the same number of rows and cols.
     *
     * @param matrix the matrix that has the same number of rows and cols.
     */
    public static void print(String[] matrix)
    {
        int cols = (int) Math.sqrt(matrix.length);

        if (cols * cols != matrix.length)
        {
            throw new RuntimeException("You must pass a matrix with same number of rows and cols, otherwise use print(String[] matrix, int rows, int cols)");
        }

        print(matrix, cols, cols);
    }

    /**
     * Prints the given matrix.
     *
     * @param matrix the matrix.
     * @param rows   the number of rows.
     * @param cols   the the number of columns.
     */
    public static void print(int[] matrix, int rows, int cols)
    {
        print(ArrayUtil.toStringArray(matrix), rows, cols);
    }

    /**
     * Prints the given matrix.
     *
     * @param matrix the matrix.
     * @param rows   the number of rows.
     * @param cols   the the number of columns.
     */
    public static void print(String[] matrix, int rows, int cols)
    {
        // the longest length, for alignment
        int longest = ArrayUtil.longestLength(matrix, true);

        int index = 0;

        // rows
        for (int i = 0; i < rows; i++)
        {
            // cols
            for (int j = 0; j < cols; j++)
            {
                String value;

                if (index >= matrix.length)
                {
                    value = "[null]";
                }
                else
                {
                    value = matrix[index];

                    if (value == null)
                    {
                        value = "[null]";
                    }
                }

                int length = value.length();

                // align the row, if we have more than one
                if (rows > 1)
                {
                    for (int k = 0; k < longest - length; k++)
                    {
                        System.out.print(" ");
                    }
                }

                System.out.print(value);

                System.out.print("  ");

                index++;
            }

            System.out.println("");
        }
    }
}