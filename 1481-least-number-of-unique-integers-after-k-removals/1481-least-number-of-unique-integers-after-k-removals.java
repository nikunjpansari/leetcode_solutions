class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) 
    {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : arr) 
        {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> e = new ArrayList<>(mp.entrySet());

        e.sort((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : e) 
        {
            if (entry.getValue() <= k) 
            {
                k -= entry.getValue();
                mp.remove(entry.getKey());
            }
            else 
                break;
        }
        return mp.size();
    }
}