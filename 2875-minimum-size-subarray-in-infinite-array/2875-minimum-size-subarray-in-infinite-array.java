class Solution {
    public int minSizeSubarray(int[] nums, int target) 
    {
        int sum=0, cnt, n=nums.length;
        for(int num: nums) 
        sum+=num;

        cnt=(target/sum)*n; 
        target=target%sum;

        if(target==0) 
        return cnt;

        int arr[]=new int[2*n];

        for(int i=0; i<n; arr[i]=arr[i+n]=nums[i], i++);        
        int min=Integer.MAX_VALUE, i=0, j=0, curr=0;

        for(;i<2*n;i++)
        {
            curr+=arr[i];
            while(curr>=target)
            {
                if(curr==target) 
                min=Math.min(min, i-j+1);
                
                curr-=arr[j++];
            }
        }
        return min==Integer.MAX_VALUE? -1: min+cnt;
    }
}