class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
    Map<Integer, Integer> mp = new HashMap<>();
        for (int x : nums)
            mp.put(x, mp.getOrDefault(x, 0) + 1);
            
        List<List<Integer>> ans = new ArrayList<>();
        while (!mp.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer>> it = mp.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                res.add(entry.getKey());
                if (entry.getValue() > 1) 
                    entry.setValue(entry.getValue() - 1);
                else 
                    it.remove();
                }
            ans.add(res);
        }
        return ans;
    }
}