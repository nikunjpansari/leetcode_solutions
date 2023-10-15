class Solution {
    public int numWays(int steps, int arrLen) {
    final int m = 1000000007;
    arrLen = Math.min(arrLen, steps + 1);
    int[][] dp = new int[arrLen][steps + 1];
    dp[0][0] = 1;

    for (int remain = 1; remain <= steps; remain++) {
        for (int curr = 0; curr < arrLen; curr++) {
            int ans = dp[curr][remain - 1];

            if (curr > 0) {
                ans = (ans + dp[curr - 1][remain - 1]) % m;
            }

            if (curr < arrLen - 1) {
                ans = (ans + dp[curr + 1][remain - 1]) % m;
            }

            dp[curr][remain] = ans;
        }
    }

    return dp[0][steps];
}

}