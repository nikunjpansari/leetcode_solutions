class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, n+1);
        int ans = n+1;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++){
            sum += arr[right];
            if (right > 0) minLen[right] = minLen[right-1];
            while (sum > target){
                sum -= arr[left];
                left++;
            }
            if (sum == target){
                int curLen = right-left+1;
                if (left > 0 && minLen[left-1] < n+1){
                    ans = Math.min(ans, minLen[left-1] + curLen);
                }
                minLen[right] = Math.min(curLen, minLen[right]);
            }
        }
        if (ans == n+1) return -1;
        else return ans;
    }
}