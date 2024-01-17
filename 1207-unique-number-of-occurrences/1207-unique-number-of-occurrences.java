class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i : arr)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        Set<Integer> set = new HashSet<>(mp.values());
        return mp.size() == set.size();
    }
}