class Solution {
   public int missingInteger(int[] nums) 
   {
    HashSet<Integer> st = new HashSet<>();
    int sum = nums[0];

    for (int num : nums) 
    st.add(num);

    for (int i = 1; i < nums.length; ++i) 
    {
        if (nums[i] - nums[i - 1] != 1)  
        break;

        sum += nums[i];
    }
    for (int j = sum; j < sum + 50; j++) 
    {
        if (!st.contains(j))  
        return j;
    }
    return 0;
}
}