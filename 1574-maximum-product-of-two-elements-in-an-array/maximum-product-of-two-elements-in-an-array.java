class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE,sec_max=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE,sec_min=Integer.MIN_VALUE;
        int a[]=new int[12];
        int res1,res2,res=0;
        for(int i=0;i<n;i++)
            {
                if(nums[i]>=max)
                {
                    sec_max=max;
                    max=nums[i];
                }
              if(nums[i]<max && nums[i]>sec_max)
                sec_max=nums[i];
               
            if(nums[i]<=min)
                {
                    sec_min=min;
                    min=nums[i];
                }
              if(nums[i]>min && nums[i]<sec_min)
                sec_min=nums[i];
                 
            }
        res1=(max-1)*(sec_max-1);
        res2=(min-1)*(sec_min-1);

        if(res1>res2)
         res=res1;
         else
         res=res2;
        
    return res;
    }
}