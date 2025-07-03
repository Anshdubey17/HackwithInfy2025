import java.util.Arrays;
import java.util.Scanner;

public class Array_partion {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums); // Sort the array
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            count += nums[i]; // Add every second element (min of the pair)
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Array_partion ap = new Array_partion(); // FIXED: Changed 'Solution' to 'Array_partion'

        // Get array size (must be even)
        System.out.print("Enter even number of elements in array: ");
        int n = scanner.nextInt();

        if (n % 2 != 0) {
            System.out.println("Array size must be even.");
            scanner.close();
            return;
        }

        int[] nums = new int[n];

        // Get array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Call the function
        int result = ap.arrayPairSum(nums); // FIXED: use 'ap' object
        System.out.println("Maximum sum of min elements from pairs: " + result);

        scanner.close();
    }
}
