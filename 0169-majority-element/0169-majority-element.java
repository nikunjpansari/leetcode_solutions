class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i : nums)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> e : mp.entrySet())
        {
            if(e.getValue() > (n/2))
            res = e.getKey();
        }
        return res;
    }
}