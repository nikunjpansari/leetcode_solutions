class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0 ,mid = 0,h=n-1;
        while(mid <= h)
        {
            if(nums[mid] == 0)
            {
                int t = nums[l];
                nums[l] = nums[mid];
                nums[mid] = t;

                l++;
                mid++;
            }
            else if(nums[mid] == 1)
            mid++;
            else
            {
                int t = nums[mid];
                nums[mid] = nums[h];
                nums[h] = t;

                h--;
            }
        }
    }
}