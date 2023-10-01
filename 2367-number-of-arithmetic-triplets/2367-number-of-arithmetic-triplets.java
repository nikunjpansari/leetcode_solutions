class Solution {
    public int arithmeticTriplets(int[] nums, int diff) 
    {
        int cnt = 0;
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i : nums)
        {
        mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(int k : nums)
        {
            cnt += (mp.containsKey(k+diff) && mp.containsKey(k+2*diff) ? 1 : 0);
        }
        return cnt;
    }
}