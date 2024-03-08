class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int res = 0;
        int mx = 0;
        for(int i : nums)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);
            mx = Math.max(mx,mp.get(i));
        }

        for(int i : nums)
        {
        if(mp.getOrDefault(i,0) == mx)
        res += 1;
        }
        return res;
    }
}