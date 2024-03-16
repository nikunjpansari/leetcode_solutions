public class Solution {
    public int findMaxLength(int[] nums) 
    {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) 
            nums[i] = -1;
        }
        
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int sum = 0, max = 0;
        
        for (int i = 0; i < nums.length; i++) 
        {
            sum += nums[i];
            if (mp.containsKey(sum)) 
                max = Math.max(max, i - mp.get(sum));
            else 
                mp.put(sum, i);
        }
        
        return max;
    }
}