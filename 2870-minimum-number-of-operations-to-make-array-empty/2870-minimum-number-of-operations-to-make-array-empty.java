class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int res = 0;
        for(int i : nums)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(int i :mp.keySet())
        {
            if(mp.get(i) == 1)
            return -1;

            int sz = mp.get(i);
            res += (sz/3) + (sz % 3 != 0 ? 1 :0);
        }
        return res;
    }
}