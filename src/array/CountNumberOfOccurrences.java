package array;

import utils.CommonUtils;

/**
 * Count number of occurrences (or frequency) in a sorted array Given a sorted array arr[] and a
 * number x, write a function that counts the occurrences of x in arr[]. Expected time complexity is
 * O(Logn) Examples:
 *
 * <p>Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 2 Output: 4 // x (or 2) occurs 4 times in arr[]
 *
 * <p>Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 3 Output: 1
 *
 * <p>Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 1 Output: 2
 *
 * <p>Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 4 Output: -1 // 4 doesn't occur in arr[]
 */
public class CountNumberOfOccurrences {

    public static int first(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key && arr[mid-1] != arr[mid])
                return mid;
            else if (arr[mid] == key)
                end = mid - 1;
            else if (arr[mid] > key)
                end = mid - 1;
            else if (arr[mid] < key)
                start = mid + 1;
        }
        return -1;
    }

    public static int last(int[] arr, int key, int start) {
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key && arr[mid + 1] != key)
                return mid;
            else if (arr[mid] == key)
                start = mid + 1;
            else if (arr[mid] < key)
                start = end + 1;
            else if (arr[mid] > key)
                end = mid - 1;
        }
        return -1;
    }

    public static int countFrequency(int[] arr, int key) {
        int first = first(arr, key);
        int last = last(arr, key, first);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5};
        CommonUtils.print("" + countFrequency(input, 2));
    }
}
