package array;

import utils.CommonUtils;

/**
 * Ceiling in a sorted array Given a sorted array and a value x, the ceiling of x is the smallest
 * element in array greater than or equal to x, and the floor is the greatest element smaller than
 * or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions
 * to find floor and ceiling of x.
 *
 * <p>Examples :
 *
 * <p>For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
 * For x = 0: floor doesn't exist in array, ceil = 1
 * For x = 1: floor = 1, ceil = 1
 * For x = 5: floor = 2, ceil = 8
 * For x = 20: floor = 19, ceil doesn't exist in array
 */
public class CeilingFunction {
    public static void main(String[] args) {
        int[] input = {1, 3, 5, 7, 9, 11, 13}; // Sorted array.
        getCeil(input, 6);
    }

    public static void getCeil(int[] arr, int key) {
        //edge cases

        // core functions
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == key) {
                CommonUtils.print("" + arr[mid]);
                return;
            }
            else if (arr[mid] > key)
                end = mid - 1;
            else if (arr[mid] < key)
                start = mid + 1;
        }
        int value = arr[mid];
        if (arr[mid] < key)
            value = arr[mid + 1];
        CommonUtils.print("" + value);
    }
}
