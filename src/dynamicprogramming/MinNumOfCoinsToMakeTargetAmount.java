package dynamicprogramming;

import java.util.Arrays;

public class MinNumOfCoinsToMakeTargetAmount {
    /*
    * Leetcode : 322
    *
    * What is the minimum number of coins to make the target amount assuming there are unlimited number of coins.
    * */


    /*
    coins = {1,5,10,25,50,100}, amount = 39

    THOUGHT : for amt = 0 to amount calculate how many min coins are needed
    */
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;

        // count the min no of coins required to find each amt from 0 to amount
        int[] count = new int[amount + 1];

        // 0 amt 0 coins
        count[0] = 0;

        // for each amt find how many coins are required. 1 <= amt <= amount
        for(int amt = 1; amt <= amount; amt++) {

            int minCoins = Integer.MAX_VALUE;

            // for each amt see how many coins are needed
            for(int coin : coins) {

                // if denomination of the coin is more than amount
                if(coin > amt) continue;

                // coins need to form 15 cents with 10 cents = 1 + coins need to form (15 - 10) = 5 cents
                int prevCoinCount = count[amt - coin];

                // the amount cannot be formed with current coin, just pick next coin
                if(prevCoinCount == -1) continue;

                minCoins = Math.min(minCoins, 1 + prevCoinCount);
            }

            // amount cannot be formed
            if(minCoins == Integer.MAX_VALUE) minCoins = -1;

            count[amt] = minCoins;
        }

        return count[amount];
    }

    /*
    THOUGHT: greedy solution

    Start with the highest denomination and walk backwards.
    Each time update count as amount / coins[iterator] and
    amount %= coins[iterator]
    */
    public int coinChangeV0(int[] coins, int amount) {

        if(coins == null || coins.length == 0) return -1;

        int count = 0;
        int iterator = coins.length - 1;

        Arrays.sort(coins);

        while(amount > 0 && iterator >= 0) {

            count += amount / coins[iterator];
            amount %= coins[iterator];
            iterator--;
        }

        return (amount == 0) ? count : -1;

    }

}
