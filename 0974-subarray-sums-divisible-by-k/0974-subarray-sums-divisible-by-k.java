class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int s = 0, res = 0,r=0;
        for (int n : nums) {
            s += n;            
            r= s % k;   
            if (r < 0) {
                r += k;     
            }          
            res += mp.getOrDefault(r, 0);
            mp.put(r , 1 + mp.getOrDefault(r, 0));
        }

        return res;     
    }
}