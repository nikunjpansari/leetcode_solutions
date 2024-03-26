class Solution {
    public int firstMissingPositive(int[] nums) {
        int c=0,val=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
            c+=1;
            if(nums[i]<=0)
            nums[i]=1;
        }
        if(c==0)
        return 1;
        for(int i=0;i<nums.length;i++){
            val=Math.abs(nums[i])-1;
            if(val>=0 && val<nums.length)
            nums[val]= (-1) * Math.abs(nums[val]);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            return (i+1);
        }

        return nums.length+1;
    }
}