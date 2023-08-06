class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) 
    {
        boolean res=false;
        int size=nums.size();

        if((size==1 && m>=1) || size == 2)
            return true;

        for(int i=0;i<size-1;i++)
        {
            int val=nums.get(i)+nums.get(i+1);
            if(val>=m)
                res=true;
        }

        return res;
    }
}