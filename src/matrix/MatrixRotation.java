package matrix;

import static utils.CommonUtils.print;

class MatrixRotation{
  public static void main(String args[]) {
    int input[][] = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    printMatrix(input);
  }

  public static void printMatrix(int matrix[][]) {
    for(int row[]: matrix) {
      for(int item: row) {
        print(item + " ");
      }
      print("\n");
    }
  }


}