package array;

import utils.CommonUtils;

import java.util.Scanner;

/*
 1          -> Testcase count
 5 7        -> Size and Given sum
 1 2 3 7 5  -> Array elements
 */

public class SubArrayWithGivenSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testcaseCount = sc.nextInt();

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < testcaseCount; i++) {
      int size = sc.nextInt();
      int requiredSum = sc.nextInt();
      int[] inputArray = new int[size];

      for (int j = 0; j < size; j++) {
        inputArray[j] = sc.nextInt();
      }

      int[] resultPositions = subArrayPositions(inputArray, requiredSum, size);
      if(i != 0) {
        result.append("\n");
      }
      if (resultPositions[0] == -1) {
        result.append(resultPositions[0]);
      } else {
        result.append(resultPositions[0]).append(" ").append(resultPositions[1]);
      }
    }

    CommonUtils.print(result.toString());
  }

  private static int[] subArrayPositions(int[] array, int sum, int size) {
    int[] resultPositions = new int[2];
    int start = 0;
    int end = 0;
    int currentSum = array[0];

    while(start <= end && end < size) {
      if(sum == currentSum) {
        break;
      }
      if(start == end && currentSum > sum && start < size - 1) {
        start++;
        end++;
        currentSum = array[start];
      } else if (currentSum < sum && end < size - 1) {
        end++;
        currentSum += array[end];
      } else {
        currentSum -= array[start];
        start++;
      }
    }

    if (sum != currentSum) {
      resultPositions[0] = resultPositions[1] = -1;
    } else {
      resultPositions[0] = start + 1;
      resultPositions[1] = end + 1;
    }
    return resultPositions;
  }
}
