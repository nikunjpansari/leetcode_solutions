class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res= new int[n];
        int l =1,r=1;

        for(int i = 0;i<n;i++)
        res[i]=1;

        for(int i=0,j=n-1;i<n-1;i++,j--)
        {
            l*=nums[i];
            r*=nums[j];
            res[i+1]*=l;
            res[j-1]*=r;
        }
        return res;
        
    }
}