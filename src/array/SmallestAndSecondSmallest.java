package array;

import utils.CommonUtils;

public class SmallestAndSecondSmallest {

    public static void search(int[] arr) {
        // edge cases
        if (arr.length == 0)
            CommonUtils.print("Wrong Input");

        // core logic
        int smallest = Math.min(arr[0], arr[1]);
        int secondSmallest = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if (arr[i] < secondSmallest)
                secondSmallest = arr[i];
        }
        CommonUtils.print("Smallest : " + smallest + ", Second Smallest : " + secondSmallest);
    }

    public static void main(String[] args){
        int[] input = {5,4,3,2,1};
        search(input);
    }
}
