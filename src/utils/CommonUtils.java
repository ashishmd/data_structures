package utils;

public class CommonUtils {
    public static void print (Object string) {
        System.out.print(string);
    }

    public static void println (Object string) {
        System.out.println(string);
    }

    public static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for(int item: row) {
                print(item + " ");
            }
            print("\n");
        }
    }
}
