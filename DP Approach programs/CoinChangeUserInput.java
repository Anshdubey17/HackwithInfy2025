import java.util.*;

public class CoinChangeUserInput {
    
    // Core coin change solution
    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] mincoinsDP = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            mincoinsDP[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && mincoinsDP[i - coin] != Integer.MAX_VALUE) {
                    mincoinsDP[i] = Math.min(mincoinsDP[i], 1 + mincoinsDP[i - coin]);
                }
            }
        }

        return mincoinsDP[amount] == Integer.MAX_VALUE ? -1 : mincoinsDP[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking number of coin types
        System.out.print("Enter number of coin denominations: ");
        int n = sc.nextInt();

        int[] coins = new int[n];
        System.out.println("Enter the coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // Taking target amount
        System.out.print("Enter the total amount: ");
        int amount = sc.nextInt();

        // Call the coinChange method
        int result = coinChange(coins, amount);

        // Output result
        if (result == -1) {
            System.out.println("It's not possible to make the amount with given coins.");
        } else {
            System.out.println("Minimum number of coins needed: " + result);
        }

        sc.close();
    }
}
