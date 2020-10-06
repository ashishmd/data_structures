package matrix;

import java.util.Scanner;

public class RottenOranges {
  static int maxCount = -1;
  static int[][] gridData;

  //    Sample Input
  //    2
  //    3 5
  //    2 1 0 2 1 1 0 1 2 1 1 0 0 2 1
  //    3 5
  //    2 1 0 2 1 0 0 1 2 1 1 0 0 2 1
  public static void main(String[] args) {
    StringBuilder result = new StringBuilder();
    Scanner sc = new Scanner(System.in);
    int testCaseCount = sc.nextInt();

    for(int t = 0; t < testCaseCount; t++) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      int[][] grid = new int[m][n];
      gridData = new int[m][n];
      for (int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) { 
          gridData[i][j] = Integer.MAX_VALUE;
          grid[i][j] = sc.nextInt();
        }
      }
      if (t != 0) {
        result.append("\n");
      }
      result.append(orangesRotting(grid));
    }
//    int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
    System.out.print(result);
  }

  private static int orangesRotting(int[][] grid) {
    int x = grid.length;
    int y = grid[0].length;
    int row, column;

    // Edge cases

    // Core function
    for(int i = 0; i < x; i++) {
      for(int j = 0; j < y; j++) {
        if (grid[i][j] == 2) {
          findLongestRoute(grid, i + 1, j, 1);
          findLongestRoute(grid, i - 1, j, 1);
          findLongestRoute(grid, i , j + 1, 1);
          findLongestRoute(grid, i , j - 1, 1);
          grid[i][j] = 2;
        }
      }
    }
    maxCount = 0;
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (grid[i][j] == 1 && gridData[i][j] == Integer.MAX_VALUE) {
          return -1;
        }
        if (maxCount < gridData[i][j] && gridData[i][j] != Integer.MAX_VALUE)
          maxCount = gridData[i][j];
      }
    }
    return maxCount;
  }

  private static void findLongestRoute(int[][] grid, int row, int column, int count) {
    int x = grid.length - 1;
    int y = grid[0].length - 1;

    if (row < 0 || row > x || column < 0 || column > y || grid[row][column] == 0) {
      return;
    } else if(grid[row][column] == 2 && gridData[row][column] != Integer.MAX_VALUE) {
      gridData[row][column] = 0;
    } else if(grid[row][column] == 2 && gridData[row][column] == Integer.MAX_VALUE) {
      return;
    } else if (grid[row][column] == 1 && count < gridData[row][column]) {
      gridData[row][column] = count;
    } else if (grid[row][column] == 1 && gridData[row][column] != Integer.MAX_VALUE) {
      return;
    }

    if (row < x)
      findLongestRoute(grid, row + 1, column, count + 1);
    if (row > 0)
      findLongestRoute(grid, row - 1, column, count + 1);
    if (column > 0)
      findLongestRoute(grid, row, column - 1, count + 1);
    if (column < y)
      findLongestRoute(grid, row, column + 1, count + 1);
  }
}
