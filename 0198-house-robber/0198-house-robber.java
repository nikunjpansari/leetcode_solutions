class Solution {
    public int rob(int[] nums) {
       int a = 0;
       int b = 0;

        for(int i : nums)
        {
            int a1 = b + i;
            int b1 = Math.max(a,b);

            a = a1;
            b = b1;
        } 
        return Math.max(a,b);
    }
}