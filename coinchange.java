import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = solution.coinChange(coins, amount);

        if (result != -1) {
            System.out.println("Minimum coins needed to make amount " + amount + " is: " + result);
        } else {
            System.out.println("It's not possible to make amount " + amount + " with the given coins.");
        }
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
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
}
