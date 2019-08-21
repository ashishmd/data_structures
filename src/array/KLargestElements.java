package array;

import sortingAlgorithms.HeapSort;
import utils.CommonUtils;

public class KLargestElements {

  public static void kLargestElements(int[] arr, int k) {
    // Edge cases
      if (k >= arr.length) {
          CommonUtils.print("All input elements");
          return;
      } else if (arr.length == 0) {
          CommonUtils.print("Invalid input");
          return;
      }

      // Build heap
      int size = arr.length - 1;
      for (int i = size/2; i >= 0; i--)
          HeapSort.heapify(arr, size, i);

      //sort k times
      for (int i = size - 1; i >= size - k; i--) {
          int temp = arr[0];
          arr[0] = arr[size];
          CommonUtils.print("" + temp);
          HeapSort.heapify(arr, i, 0);
      }
  }

    public static void main(String[] args) {
        int[] input = {5, 2, 4, 1, 3};
        kLargestElements(input, 2);
    }
}
