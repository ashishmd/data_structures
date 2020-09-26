package matrix;

import static utils.CommonUtils.*;

public class RotateMatrix90Degree {
  public static void main(String[] args) {
    int input[][] = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };
    printMatrix(input);

    rotateMatrix(input);

    print("\nrotated matrix: \n\n");

    printMatrix(input);
  }

  private static void rotateMatrix(int[][] matrix) {
    int start = 0;
    int end = matrix.length - 1;

    int previousElement = matrix[start][start];

    while(start < end) {
      for(int i = 0; i < (end - start); i++) {
        matrix[start + i][start] = matrix[end][start + i];
        matrix[end][start + i] = matrix[end-i][end];
        matrix[end-i][end] = matrix[start][end-i];
        matrix[start][end-i] = previousElement;

        previousElement = matrix[i+1][start];
      }

      start += 1;
      end -= 1;
      previousElement = matrix[start][start];
    }
  }
}
