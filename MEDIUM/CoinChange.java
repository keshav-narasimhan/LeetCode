class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] table = new int[amount + 1];
        table[0] = 0;
        int min;
        
        for (int index = 1; index <= amount; index++) {
            min = Integer.MAX_VALUE;
            for (int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
                if (coins[coinIndex] <= index) {
                    if (table[index - coins[coinIndex]] < min) {
                        min = table[index - coins[coinIndex]];
                    }
                }
            }
            if (min != Integer.MAX_VALUE) {
                table[index] = min + 1;
            } else {
                table[index] = Integer.MAX_VALUE;
            }
        }
        
        if (table[amount] == Integer.MAX_VALUE/* && amount != 0*/) {
            return -1;
        }
        return table[amount];
    }
}
