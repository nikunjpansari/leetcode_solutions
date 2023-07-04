// Time Complexity : O(N)
// Space Complexity : O(N) using HashMap
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i : nums) 
        {
            if (mp.containsKey(i)) 
                mp.put(i, mp.get(i) + 1);
            else 
                mp.put(i, 1);
        }
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) 
        {
            if(e.getValue()==1)
            res=e.getKey();
        }
        return res;
    }
}