import java.time.Duration;
import java.time.Instant;

class LinearSearch
{
    public static void main(String[] args)
    {
        Integer[] testCase  = new Integer[100000000];
        for (int i = 0; i < 100000000; i++)
        {
            testCase[i] = i;
        }

        Instant start = Instant.now();
        iterative_search(testCase, 99999999);
        Instant end = Instant.now();
        System.out.println("Iterative approach took: " + Duration.between(start, end).toMillis());

        start = Instant.now();
        if (recursive_approach(testCase, 0, 100000000 - 1, 99999999))
            System.out.println("Found");
        end = Instant.now();
        System.out.println("Recursive approach took: " + Duration.between(start, end).toMillis());
    }

    private static Boolean recursive_approach(Integer[] array, Integer left_index, Integer right_index, Integer key)
    {
        if (left_index > right_index)
            return false;

        if (array[left_index].equals(key))
            return true;
        else if (array[right_index].equals(key))
            return true;
        return recursive_approach(array, left_index + 1, right_index -1, key);
    }

    private static void iterative_search(Integer[] a, Integer key)
    {
        for(int i = 0; i < a.length ; i++)
        {
            if(key.equals(a[i]))
            {
                System.out.println("Found at position : " + i);
            }
        }

    }
}
