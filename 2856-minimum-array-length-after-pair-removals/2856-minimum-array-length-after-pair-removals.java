class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) 
    {
        int i = 0;
        int n = nums.size();

        if((long)nums.get(0) == (long)nums.get(n-1)) 
        return n; 

        int max = 0;

       while(i <n) 
       {
           int j = i + 1;

           while(j < n && nums.get(i) == nums.get(j)) 
           j++;

           int temp = j - i;

           if(temp > 1) 
           max = Math.max(temp, max);
           i = j;
       }
        
        int cnt = 0;
        
        int distinct = n - max;
        if(distinct >= max) 
        {
            if(n % 2 != 0) 
            cnt++;
        }
        else 
        cnt += max - distinct;

        return cnt;
    }
}