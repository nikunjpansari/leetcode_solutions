class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n=nums.length;
        int cnt=0;
        int a[]=nums.clone();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
               if(nums[i]==a[j])
           {
               if(i<j)
               {
                   cnt++;
               } 
            }
           
           }
        }
        return cnt;
    }
}