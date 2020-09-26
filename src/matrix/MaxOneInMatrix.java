package matrix;

import static utils.CommonUtils.print;

public class MaxOneInMatrix {
  public static void main(String[] args) {
    int[][] inputMatrix = {
      {1, 0, 1, 0},
      {0, 0, 1, 0},
      {1, 1, 1, 0},
      {1, 1, 1, 1}
    };

    getMaxOneRow(inputMatrix);

  }

  private static void getMaxOneRow(int[][] matrix) {
    // Edge cases

    // Core functionality

    int m = matrix.length;
    int n = matrix[0].length;

    int maxCount = 0;
    int maxCountRow = 0;

    for(int i = 0; i < m; i++) {
      int rowCount = 0;
      for(int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          rowCount++;
        }
      }
      if (rowCount > maxCount) {
        maxCount = rowCount;
        maxCountRow = i;
      }
    }

    print("Row with max count is " + maxCountRow);
  }
}
