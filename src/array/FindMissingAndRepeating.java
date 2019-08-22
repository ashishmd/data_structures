package array;

import utils.CommonUtils;

/**
 * Find the repeating and the missing | Added 3 new methods Given an unsorted array of size n. Array
 * elements are in the range from 1 to n. One number from set {1, 2, …n} is missing and one number
 * occurs twice in the array. Find these two numbers. Examples:
 *
 * <p>Input: arr[] = {3, 1, 3} Output: Missing = 2, Repeating = 3 Explanation: In the array, 2 is
 * missing and 3 occurs twice
 *
 * <p>Input: arr[] = {4, 3, 6, 2, 1, 1} Output: Missing = 5, Repeating = 1
 */
public class FindMissingAndRepeating {
    public static void main(String[] args) {
        int[] arr = {3, 1, 3};
        countWithAuxilarrySpace(arr);
    }

    public static void countWithAuxilarrySpace(int[] arr) {
        int[] temp = new int[arr.length];
        CommonUtils.print("Repeating elements: ");
        for(int i = 0; i < arr.length; i++) {
            if (temp[arr[i] - 1] == 1)
                CommonUtils.print(arr[i]+ "");
            else
                temp[arr[i] - 1] = 1;
        }

        CommonUtils.print("Missing Elements");
        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i] == 0)
                CommonUtils.print(""+ (i + 1));
        }
    }
}
