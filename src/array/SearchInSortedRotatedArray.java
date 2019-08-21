package array;

import utils.CommonUtils;

/**
 * Search an element in a sorted and rotated array
 */
public class SearchInSortedRotatedArray {

    public static void search(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
              System.out.println("wrong input");
              return;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key) {
                CommonUtils.print("Found");
                return;
            }

            else if (arr[mid] > arr[start]) {
                if (key >= arr[start] && key < arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            else {
                if (key <= arr[end] && key > arr[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

    }
    public static void main(String[] args) {
        int[] input = {5, 6, 7, 8, 9, 10, 1, 2};
        search(input, 11);
    }
}
