class Solution {
    public int searchInsert(int[] nums, int x) {
        int l = 0;
        int h = nums.length;

        while(l < h)
        {
            int mid = l + (h-l)/2;
            if(nums[mid] < x)
            l = mid +1 ;
            else
            h = mid;
        }
        return l;
    }
}