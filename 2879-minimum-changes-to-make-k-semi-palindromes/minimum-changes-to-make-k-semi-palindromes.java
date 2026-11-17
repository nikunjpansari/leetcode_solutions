class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                cost[l][r] = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int changes = 0;
                    for (int offset = 0; offset < d; offset++) {
                        int left = l + offset;
                        int right = l + offset
                                + ((len - 1 - offset) / d) * d;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right))
                                changes++;

                            left += d;
                            right -= d;
                        }
                    }

                    cost[l][r] = Math.min(cost[l][r], changes);
                }
            }
        }

        int INF = 1000000000;
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++)
            java.util.Arrays.fill(dp[i], INF);

        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            for (int i = 2 * parts; i <= n; i++) {
                for (int j = 2 * (parts - 1); j <= i - 2; j++) {
                    if (dp[parts - 1][j] != INF) {
                        dp[parts][i] = Math.min(
                            dp[parts][i],
                            dp[parts - 1][j] + cost[j][i - 1]
                        );
                    }
                }
            }
        }

        return dp[k][n];
    }
}