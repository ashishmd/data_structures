import java.time.Duration;
import java.time.Instant;

public class BinarySearch
{
    public static void main(String[] args)
    {
        int[] test_case  = LinearSearch.get_test_case();
        int key = test_case.length - 1;

        Instant start = Instant.now();
        if (recursive_approach(test_case, 0, 100000000 - 1, key))
            System.out.println("Found");
        Instant end = Instant.now();
        System.out.println("Recursive approach took: " + Duration.between(start, end).toMillis());

        start = Instant.now();
        if (iterative_approach(test_case, key))
            System.out.println("Found");
        end = Instant.now();
        System.out.println("Iterative approach took: " + Duration.between(start, end).toMillis());
    }

    private static boolean recursive_approach(int[] array, int left, int right, int key)
    {
        if (left > right)
            return false;

        int mid = (left + right) / 2;

        if (array[mid] == key)
            return true;
        else if (array[mid] > key)
            return recursive_approach(array, left, mid - 1, key);
        else if (array[mid] < key)
            return recursive_approach(array, mid + 1, right, key);
        return false;
    }

    private static boolean iterative_approach(int[] array, int key)
    {
        int left = 0;
        int right = array.length-1;

        while (left < right)
        {
            int mid = (left + right) / 2;
            if (array[mid] == key)
                return true;
            else if (array[mid] < key)
                right = mid - 1;
            else if (array[mid] > key)
                left = mid + 1;
        }
        return false;
    }
}
