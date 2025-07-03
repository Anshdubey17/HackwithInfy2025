import java.util.Scanner;

public class buytwochocolates {

    public int buyChoco(int[] prices, int money) {
        int minprice = Integer.MAX_VALUE;
        int secminprice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minprice) {
                secminprice = minprice;
                minprice = price;
            } else {
                secminprice = Math.min(secminprice, price);
            }
        }

        if (minprice + secminprice > money) {
            return money;
        }

        return money - (minprice + secminprice);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        buytwochocolates btc = new buytwochocolates();  // changed from 'Solution' to 'buytwochocolates'

        // Ask user for array size
        System.out.print("Enter number of chocolates (array size): ");
        int n = scanner.nextInt();

        int[] prices = new int[n];

        // Take array input
        System.out.println("Enter prices of chocolates:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Take money input
        System.out.print("Enter the amount of money you have: ");
        int money = scanner.nextInt();

        // Call the method and print result
        int result = btc.buyChoco(prices, money);  // use the instance 'btc'
        System.out.println("Remaining money after buying two cheapest chocolates: " + result);

        scanner.close();
    }
}
