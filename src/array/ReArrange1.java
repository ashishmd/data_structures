package array;

public class ReArrange1 {
    public static void main(String[] args) {
        int[] arr = { 12, 11, -13, -5, 6, -7, 5, -3, -6 };
        System.out.println("Count");rearrange(arr);
    }

    static int rearrange(int[] array) {
        int count = 0;
        int low = 0;
        int high = array.length - 1;
        while(low < high) {
            if (array[low] > 0 && array[high] < 0) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
                count++;
            }
            if (array[low] < 0)
                low++;
            if (array[high] > 0)
                high --;
        }

        for (int a : array) {
          System.out.println(a);
        }
        return count;
    }
}
