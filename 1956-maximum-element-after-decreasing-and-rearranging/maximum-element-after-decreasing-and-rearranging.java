class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int res = 0 ;
        for(int i : arr)
            res = Math.min(res+1,i);
        return res;
    }
}