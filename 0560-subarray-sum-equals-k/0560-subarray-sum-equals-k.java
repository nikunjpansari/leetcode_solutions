// Time Complexity : O(N)
// Space Complexity : O(N)
class Solution {
   public int subarraySum(int[] arr, int k) {
    int n = arr.length; // size of the given array.
    Map<Integer, Integer> mpp = new HashMap<>();
    int preSum = 0, cnt = 0;

    mpp.put(0, 1); // Setting 0 in the map.
    for (int i = 0; i < n; i++) {
        // add current element to prefix Sum:
        preSum += arr[i];

        // Calculate x-k:
        int remove = preSum - k;

        // Add the number of subarrays to be removed:
        cnt += mpp.getOrDefault(remove, 0);

        // Update the count of prefix sum in the map.
        mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
    }
    return cnt;
}

}