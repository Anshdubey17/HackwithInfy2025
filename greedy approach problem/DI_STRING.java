import java.util.Scanner;
import java.util.Arrays;

public class DI_STRING {

    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];
        int leftpointer = 0;
        int rightpointer = s.length();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                result[index++] = leftpointer++;
            } else {
                result[index++] = rightpointer--;
            }
        }

        // Assign the last remaining value
        result[index] = leftpointer; // left == right at this point

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DI_STRING obj = new DI_STRING();

        System.out.print("Enter a string of I's and D's (e.g., IDID): ");
        String s = scanner.nextLine().trim();

        int[] result = obj.diStringMatch(s);

        System.out.println("Resulting permutation:");
        System.out.println(Arrays.toString(result));

        scanner.close();
    }
}
