package arrays;

public class MaxProfit2Transactions {

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        MaxProfit2Transactions re = new MaxProfit2Transactions();
        System.out.println(re.maxProfit(prices));

    }

    public int maxProfit(int[] prices) {
        // buy when it's minimum
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        // sell when profit is more than 0
        int sell1 = 0, sell2 = 0;

        for (int price : prices) {

            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);

            buy2 = Math.max(buy2, (sell1 - price));
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}
