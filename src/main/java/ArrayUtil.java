
import java.security.*;
import java.util.*;

/**
 * ArrayUtil.
 */
class ArrayUtil {
    private static final SecureRandom _secureRandom = new SecureRandom();

    /**
     * This class is not meant to be instantiated
     */
    private ArrayUtil() {
    }

    /**
     * Returns the smallest int of the given array.
     *
     * @param array the array.
     * @return the smallest int of the given array.
     */
    public static int smallest(int[] array) {
        int[] copy = new int[array.length];

        System.arraycopy(array, 0, copy, 0, array.length);

        Arrays.sort(copy);

        return copy[0];
    }

    /**
     * Returns the longest length of the elements in the given array.
     *
     * @param array            the array.
     * @param specialNullValue if true a null value will be considered as the String "[null]".
     * @return the longest length of the elements in the given array.
     */
    public static int longestLength(String[] array, boolean specialNullValue) {
        int longest = 0;

        for (String s : array) {
            if (s == null) {
                if (specialNullValue) {
                    s = "[null]";
                } else {
                    continue;
                }
            }

            int length = s.length();

            if (length > longest) {
                longest = length;
            }
        }

        return longest;
    }

    /**
     * Returns the biggest int of the given array.
     *
     * @param array the array.
     * @return the biggest int of the given array.
     */
    public static int biggest(int[] array) {
        int[] copy = new int[array.length];

        System.arraycopy(array, 0, copy, 0, array.length);

        Arrays.sort(copy);

        return copy[copy.length - 1];
    }

    /**
     * Merge the two given String arrays.
     * <p/>
     * The order of the elements of the merged array is the insertion order.
     * <p/>
     * For example :
     * <p/>
     * String[] array1 = {"tree", "bird", "sky", "grass", "flower"};<br>
     * String[] array2 = {"grass", "sky", "bird", "apple", "flower"};<br>
     * <p/>
     * ArrayUtil.mergeStringArrays(array1, array2);
     * <p/>
     * will have a result of :
     * <p/>
     * {"tree", "bird", "sky", "grass", "flower", "apple"}
     *
     * @param array1 the first array.
     * @param array2 the second array.
     * @return the merged array.
     */
    public static String[] mergeStringArrays(String[] array1, String[] array2) {
        Set<String> set = new LinkedHashSet<String>(array1.length);

        Collections.addAll(set, array1);

        Collections.addAll(set, array2);

        return set.toArray(new String[set.size()]);
    }

    /**
     * Shift the elements of the given array to the right.
     *
     * @param array the array.
     */
    public static void shiftRight(String[] array) {
        String last = array[array.length - 1];

        System.arraycopy(array, 0, array, 1, array.length - 1);

        array[0] = last;
    }

    /**
     * Returns true if the given array contains the given Object.
     *
     * @param object the Object to find in the array, if null the result will be false.
     * @param array  the array of Objects.
     * @return true if the given array contains the given Object.
     */
    public static boolean contains(Object object, Object[] array) {
        if (object == null) {
            return false;
        }

        for (Object element : array) {
            if (object.equals(element)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns true if the given array contains the given int.
     *
     * @param value the int to find in the array.
     * @param array the array of ints.
     * @return true if the given array contains the given int.
     */
    public static boolean contains(int value, int[] array) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns true if the given array contains the given char.
     *
     * @param value the char to find in the array.
     * @param array the array of chars.
     * @return true if the given array contains the given char.
     */
    public static boolean contains(char value, char[] array) {
        for (char element : array) {
            if (element == value) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the given String as an array of ints, using the given
     * delimiter to parse them.
     *
     * @param string    the String containing the ints.
     * @param delimiter the delimiter.
     * @return the array of ints.
     */
    public static int[] stringToIntArray(String string, String delimiter) {
        String[] data = string.split(delimiter);

        return toIntArray(data);
    }

    /**
     * Transforms an int array into a single String, using the given delimiter
     * to delimit the array elements.
     *
     * @param array     the array.
     * @param delimiter the delimiter.
     * @return a single String from the given String array.
     */
    public static String arrayToString(int[] array, String delimiter) {
        String[] stringArray = toStringArray(array);

        return arrayToString(stringArray, delimiter, null, null);
    }

    /**
     * Transforms a String array into a single String, using the given delimiter
     * to delimit the array elements.
     *
     * @param array     the array.
     * @param delimiter the delimiter.
     * @return a single String from the given String array.
     */
    public static String arrayToString(String[] array, String delimiter) {
        return arrayToString(array, delimiter, null, null);
    }


    /**
     * Transforms a String array into a single String, using the given delimiter
     * to delimit the array elements.
     *
     * @param array     the array.
     * @param delimiter the delimiter.
     * @param prefix    the String that will be put before every array element, can
     *                  be null.
     * @param suffix    the String that will be put after every array element, can
     *                  be null.
     * @return a single String from the given String array.
     */
    public static String arrayToString(String[] array, String delimiter, String prefix, String suffix) {
        if (array == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(128);

        if (prefix != null) {
            builder.append(prefix);
        }

        builder.append(array[0]);

        if (suffix != null) {
            builder.append(suffix);
        }

        for (int i = 1; i < array.length; i++) {
            builder.append(delimiter);

            if (prefix != null) {
                builder.append(prefix);
            }

            builder.append(array[i]);

            if (suffix != null) {
                builder.append(suffix);
            }
        }

        return builder.toString();
    }

    /**
     * Adds the given String to the given String array.
     *
     * @param value  the String to add.
     * @param source the source array.
     * @return a new String array with the given String added.
     */
    public static String[] add(String value, String[] source) {
        String[] destination = new String[source.length + 1];

        System.arraycopy(source, 0, destination, 0, source.length);

        destination[destination.length - 1] = value;

        return destination;
    }

    /**
     * Removes the elements of the given <code>remove</code> array from the given
     * <code>subject</code> array.
     *
     * @param subject the array to remove the elements from.
     * @param remove  the array containing the elements to remove.
     * @return a new array with the wanted elements removed.
     */
    public static String[] removeFromArray(String[] subject, String[] remove) {
        List<String> result = new ArrayList<String>();

        for (String element : subject) {
            if (contains(element, remove)) {
                continue;
            }

            result.add(element);
        }

        return result.toArray(new String[result.size()]);
    }

    /**
     * Removes the given int value from the given int array.
     *
     * @param array  the int array.
     * @param remove the int value to remove.
     * @return a new array with the wanted elements removed.
     */
    public static int[] removeFromArray(int[] array, int remove) {
        List<Integer> clean = new ArrayList<Integer>();

        for (int element : array) {
            if (element == remove) {
                continue;
            }

            clean.add(element);
        }

        int[] result = new int[clean.size()];

        for (int i = 0; i < clean.size(); i++) {
            result[i] = clean.get(i);
        }

        return result;
    }

    /**
     * Shuffles the given array of ints.
     *
     * @param array the array.
     * @return the given array of ints.
     */
    public static int[] shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int position = _secureRandom.nextInt(array.length);

            int temp = array[i];

            array[i] = array[position];

            array[position] = temp;
        }

        return array;
    }

    /**
     * Shuffles the given array of chars.
     *
     * @param array the array.
     * @return the given array of chars.
     */
    public static char[] shuffle(char[] array) {
        for (int i = 0; i < array.length; i++) {
            int position = _secureRandom.nextInt(array.length);

            char temp = array[i];

            array[i] = array[position];

            array[position] = temp;
        }

        return array;
    }

    /**
     * Shuffles the given array of Strings.
     *
     * @param array the array.
     * @return the given array of Strings shuffled.
     */
    public static String[] shuffle(String[] array) {
        for (int i = 0; i < array.length; i++) {
            int position = _secureRandom.nextInt(array.length);

            String temp = array[i];

            array[i] = array[position];

            array[position] = temp;
        }

        return array;
    }

    /**
     * Converts the given char array to a String array.
     *
     * @param chars the characters.
     * @return the String array.
     */
    public static String[] toStringArray(char[] chars) {
        String[] result = new String[chars.length];

        for (int i = 0; i < chars.length; i++) {
            result[i] = String.valueOf(chars[i]);
        }

        return result;
    }

    /**
     * Converts the given ints array to a String array.
     *
     * @param ints the ints.
     * @return the String array.
     */
    public static String[] toStringArray(int[] ints) {
        String[] result = new String[ints.length];

        for (int i = 0; i < ints.length; i++) {
            result[i] = String.valueOf(ints[i]);
        }

        return result;
    }

    /**
     * Returns the index of the given String in the given array.
     *
     * @param array the array.
     * @return the String.
     */
    public static int indexOf(String[] array, String string) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(string)) {
                return i;
            }
        }

        // not found
        return -1;
    }

    /**
     * Returns a copy of the given array.
     *
     * @param array the array.
     * @return a copy of the given array.
     */
    public static String[] copy(String[] array) {
        String[] copy = new String[array.length];

        System.arraycopy(array, 0, copy, 0, array.length);

        return copy;
    }

    /**
     * Returns a copy of the given array.
     *
     * @param array the array.
     * @return a copy of the given array.
     */
    public static int[] copy(int[] array) {
        int[] copy = new int[array.length];

        System.arraycopy(array, 0, copy, 0, array.length);

        return copy;
    }

    /**
     * Makes a copy of the given array and returns it shuffled.
     *
     * @param array the array.
     * @return the given array shuffled.
     */
    public static String[] shuffleCopy(String[] array) {
        return shuffle(copy(array));
    }

    /**
     * Makes a copy of the given array and returns it shuffled.
     *
     * @param array the array.
     * @return the given array shuffled.
     */
    public static int[] shuffleCopy(int[] array) {
        return shuffle(copy(array));
    }

    /**
     * Reverse the given String array.
     *
     * @param array the array of Strings.
     */
    public static void reverse(String[] array) {
        String temp;

        int size = array.length;

        for (int i = 0; i < size / 2; i++) {
            temp = array[i];

            array[i] = array[size - 1 - i];

            array[size - 1 - i] = temp;
        }
    }

    /**
     * Returns the sum of ints in the given array.
     *
     * @param array the array of ints.
     * @return the sum of ints in the given array.
     */
    public static int sum(int[] array) {
        int sum = 0;

        for (int i : array) {
            sum += i;
        }

        return sum;
    }

    /**
     * Reverse the given int array.
     *
     * @param array the array of ints.
     */
    public static void reverse(int[] array) {
        int temp;

        int size = array.length;

        for (int i = 0; i < size / 2; i++) {
            temp = array[i];

            array[i] = array[size - 1 - i];

            array[size - 1 - i] = temp;
        }
    }

    /**
     * Returns a String representation of the given array.
     *
     * @param array     the array.
     * @param delimiter the delimiter.
     * @return a String representation of the given array.
     */
    public static String toString(int[] array, String delimiter) {
        StringBuilder result = new StringBuilder();

        int i = 0;

        for (int s : array) {
            result.append(s);

            if (i < array.length - 1) {
                result.append(delimiter);
            }

            i++;
        }

        return result.toString();
    }

    /**
     * Returns a String representation of the given array.
     *
     * @param array     the array.
     * @param delimiter the delimiter.
     * @return a String representation of the given array.
     */
    public static String toString(String[] array, String delimiter) {
        StringBuilder result = new StringBuilder();

        int i = 0;

        for (String s : array) {
            result.append(s);

            if (i < array.length - 1) {
                result.append(delimiter);
            }

            i++;
        }

        return result.toString();
    }

    /**
     * Returns the given array of Strings as an array of ints.
     *
     * @param array the array of Strings.
     * @return the array of ints.
     */
    public static int[] toIntArray(String[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }

        return result;
    }

    /**
     * Returns the given List of Integers as an array of ints.
     *
     * @param list the List of Integers.
     * @return the array of ints.
     */
    public static int[] toIntArray(List<Integer> list) {
        int[] array = new int[list.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}