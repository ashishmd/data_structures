package array;

/**
 * You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no
 * duplicates in the list. One of the integers is missing in the list. Write an efficient code to
 * find the missing integer.
 *
 * Example :
 *
 * Input: arr[] = {1, 2, 4,, 6, 3, 7, 8} Output: 5
 *
 * Input: arr[] = {1, 2, 3, 5} Output: 4
 */
public class FindMissingNumber {

    public static void findMissingNumber(int[] arr) {
        for(int i = 0; i< arr.length; i++) {
            if (arr[i] != i + 1)
                System.out.println("Missing Number is " + (i + 1));
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        findMissingNumber(arr);
    }
}
