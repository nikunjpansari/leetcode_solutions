// Time complexity: O(n log n + k)
// Space complexity: O(n)
class Solution {
      public long putMarbles(int[] W, int k) {
        int n = W.length;
        int[] pairs = new int[n - 1];
        for (int i = 1; i < n; i++) {
            pairs[i - 1] = W[i] + W[i - 1];
        }
        Arrays.sort(pairs);
        
        long min_sum = 0;
        long max_sum = 0;
        for (int i = 0; i < k - 1; i++) {
            min_sum += pairs[i];
            max_sum += pairs[n - i - 2];
        }
        
        return max_sum - min_sum;
    }
}