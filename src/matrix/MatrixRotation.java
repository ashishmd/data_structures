package matrix;

import utils.CommonUtils;

import static utils.CommonUtils.printMatrix;

class MatrixRotation{
  public static void main(String args[]) {
    int input[][] = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };
    printMatrix(input);

    rotateMatrix(input);

    CommonUtils.print("Rotated matrix : \n");

    printMatrix(input);
  }

  public static void rotateMatrix(int[][] matrix) {
    int start = 0;
    int end = matrix.length - 1;
    int previous = matrix[start][start];
    while (start <= end) {
      for (int i = start; i < end; i++) {
        matrix[i][start] = matrix[i+1][start];
      }

      for (int i = start; i < end; i++) {
        matrix[end][i] = matrix[end][i+1];
      }

      for (int i = end; i > start; i--) {
        matrix[i][end] = matrix[i-1][end];
      }

      for (int i = end; i > start; i--) {
        matrix[start][i] = matrix[start][i-1];
      }

      matrix[start][start+1] = previous;
      start += 1;
      end -= 1;

      previous = matrix[start][start];
    }
  }
}