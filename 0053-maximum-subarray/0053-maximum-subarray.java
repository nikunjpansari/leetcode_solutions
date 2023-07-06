// Time Complexity : O(N)
// Space Complexity : O(1)
class Solution {
    public int maxSubArray(int[] arr) {
        int m=Integer.MIN_VALUE;
        int n = arr.length;
       
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return (int)maxi;
    }
}