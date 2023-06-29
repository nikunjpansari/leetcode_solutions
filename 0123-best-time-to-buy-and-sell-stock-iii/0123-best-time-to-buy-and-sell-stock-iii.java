class Solution {
    public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] ahead = new int[2][3];
    int[][] cur = new int[2][3];

    for (int ind = n - 1; ind >= 0; ind--) {
        for (int buy = 0; buy <= 1; buy++) {
            for (int cap = 1; cap <= 2; cap++) {
                if (buy == 0) { // We can buy the stock
                    cur[buy][cap] = Math.max(0 + ahead[0][cap], -prices[ind] + ahead[1][cap]);
                }

                if (buy == 1) { // We can sell the stock
                    cur[buy][cap] = Math.max(0 + ahead[1][cap], prices[ind] + ahead[0][cap - 1]);
                }
            }
        }
        ahead = cur.clone();
    }

    return ahead[0][2];
    }
}