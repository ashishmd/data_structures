import java.time.Duration;
import java.time.Instant;

public class LinearSearch {
    /**
     * Results for testcase creation:
     *  - On using Integer data type, data insertion took 44799 seconds.
     *  - On using int (primitive) data type, data insertion took 241 milli seconds.
     *
     * Result for Search:
     *  - Recursive approach is faster since number of stacks will be half. Took 0 milli seconds.
     *  - Linear approach took 45 milli seconds.
     *
     * @param args:
     */

    public static void main(String[] args) {
        int[] test_case  = get_test_case();
        int key = test_case.length - 1;

        Instant start = Instant.now();
        iterative_search(test_case, key);
        Instant end = Instant.now();
        System.out.println("Iterative approach took: " + Duration.between(start, end).toMillis());

        start = Instant.now();
        if (recursive_approach(test_case, 0, test_case.length - 1, key))
            System.out.println("Found");
        end = Instant.now();
        System.out.println("Recursive approach took: " + Duration.between(start, end).toMillis());
    }

    private static Boolean recursive_approach(int[] array, int left_index, int right_index, int key) {
        if (left_index > right_index)
            return false;

        if (array[left_index] == key)
            return true;
        else if (array[right_index] == key)
            return true;
        return recursive_approach(array, left_index + 1, right_index, key);
    }

    private static void iterative_search(int[] a, int key) {
        int length = a.length;
        for(int i = 0; i < length ; i++) {
            if(key == a[i]) {
                System.out.println("Found at position : " + i);
            }
        }

    }

    public static int[] get_test_case() {
        int[] test_case  = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            test_case[i] = i;
        }
        return test_case;
    }
}
