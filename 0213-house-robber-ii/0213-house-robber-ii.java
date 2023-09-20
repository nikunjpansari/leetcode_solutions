class Solution {
   public int rob(int[] nums) 
    {
    if (nums.length == 1) 
        return nums[0];

    int a = 0;
    int b = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        int a1 = b + nums[i];
        int b1 = Math.max(a, b);
        a = a1;
        b = b1;
    }
    int max1 = Math.max(a, b);

    a = 0;
    b = 0;
    for (int i = 1; i < nums.length; i++) {
        int a2 = b + nums[i];
        int b2 = Math.max(a, b);
        a = a2;
        b = b2;
    }
    int max2 = Math.max(a, b);

    return Math.max(max1, max2);
}

}