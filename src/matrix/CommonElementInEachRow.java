package matrix;

import static utils.CommonUtils.print;

public class CommonElementInEachRow {
  public static void main(String[] args) {
    Integer[][] input= {
      {2, 1, 4, 3},
      {1, 2, 3, 2},
      {3, 6, 2, 3},
      {5, 2, 5, 3}
    };

    findCommonElements(input);
  }

  private static void findCommonElements(Integer[][] matrix) {
    sort(matrix[0]);
    for (int i = 1; i < matrix[0].length; i++) {
      sort(matrix[i]);
      int ptr1 = 0;
      int ptr2 = 0;
      int size = matrix[i].length;

      for(int j = 0; j < size; j++) {
        if (ptr1 >= size || ptr2 >= size) {
          continue;
        }
        if(matrix[0][ptr1] == null){
          ptr1++;
          continue;
        }
        if(matrix[0][ptr1] == matrix[i][ptr2]) {
          ptr1++;
          ptr2++;
        } else if(matrix[0][ptr1] < matrix[i][ptr2]) {
          matrix[0][ptr1] = null;
          ptr1++;
        } else {
          ptr2++;
        }
      }

      for(int j = ptr1; j < size; j++) {
        matrix[0][j] = null;
      }
    }

    print("Common Elements are : ");
    for (int k = 0; k < matrix[0].length; k++) {
      if(matrix[0][k] != null) {
        print(" " + matrix[0][k]);
      }
    }
  }

  private static void sort(Integer[] array) {
    int size = array.length;

    for (int i = size/2 - 1; i >= 0; i--) {
      heapify(array, size, i);
    }

    for(int i = size - 1; i >= 0; i--) {
      int temp = array[0];
      array[0] = array[i];
      array[i] = temp;

      heapify(array, i, 0);
    }
  }

  private static void heapify(Integer[] array, int size, int i) {
    int l = i * 2 + 1;
    int r = i * 2 + 2;
    int largest = i;

    if (l < size && array[l] > array[largest]) {
      largest = l;
    }

    if (r < size && array[r] > array[largest]) {
      largest = r;
    }

    if (largest != i) {
      int swap = array[i];
      array[i] = array[largest];
      array[largest] = swap;

      heapify(array, size, largest);
    }
  }
}
