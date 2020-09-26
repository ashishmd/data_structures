package matrix;

import static utils.CommonUtils.print;

public class MaxOneRowInSortedMatrix {
  public static void main(String[] args) {
    int[][] inputMatrix = {
      {0, 0, 1, 1},
      {0, 0, 0, 1},
      {0, 0, 0, 0},
      {1, 1, 1, 1}
    };

    getMaxOneRow(inputMatrix);

  }

  private static void getMaxOneRow(int[][] matrix) {
    // Edge cases

    if(matrix.length == 0) {
      print("Invalid Input");
      return;
    }

    // Core functionality
    int m = matrix.length;

    int maxCount = 0;
    int maxCountRow = 0;

    for(int i = 0; i < m; i++) {
      int rowSize = matrix[i].length;
      int count = 0;

      // Do a binary search to find the position of first one;
      int position = positionOfFirstOne(matrix[i]);

      if (position == -1) {
        continue;
      }

      count = rowSize - position - 1;
      if (count > maxCount) {
        maxCount = count;
        maxCountRow = i;
      }
    }

    print("Max count is present in row: " + maxCountRow);
  }

  private static int positionOfFirstOne(int[] array) {
    int size = array.length;

    int start = 0;
    int end = size - 1;
    int mid = 0;

    while(start < end) {
      mid = (start + end) / 2;

      if(array[mid] != array[mid-1] && array[mid] == array[mid+1]) {
        return mid;
      } else if (array[mid] == array[mid-1] && array[mid] != array[mid+1]) {
        return mid + 1;
      } else if (array[mid] == 0) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    if (array[mid] == 1) {
      return 0;
    } else {
      return -1;
    }
  }
}
