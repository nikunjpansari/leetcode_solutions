class Solution {
    public int numOfWays(int[] nums) {
        long mod = 1000000007;
        int n = nums.length;

        long[][] table = new long[n + 1][n + 1];

        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < i + 1; ++j)
                table[i][j] = 1L;
        }

        for (int i = 0; i < n + 1; ++i) {
            for (int j = 1; j < i; ++j) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod;
            }
        }

        long ans = dfs(nums, table, mod);
        return (int) ((ans % mod - 1) % mod);
    }

    private long dfs(int[] nums, long[][] table, long mod) {
        int n = nums.length;
        if (n <= 2) return 1;

        int[] left = new int[n];
        int[] right = new int[n];
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[0]) left[leftIndex++] = nums[i];
            else right[rightIndex++] = nums[i];
        }

        int[] leftArray = new int[leftIndex];
        int[] rightArray = new int[rightIndex];
        System.arraycopy(left, 0, leftArray, 0, leftIndex);
        System.arraycopy(right, 0, rightArray, 0, rightIndex);

        long leftRes = dfs(leftArray, table, mod) % mod;
        long rightRes = dfs(rightArray, table, mod) % mod;

        int leftLen = leftIndex;
        int rightLen = rightIndex;
        return (((table[n - 1][leftLen] * leftRes) % mod) * rightRes) % mod;
    }
}
