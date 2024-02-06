class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
        return new ArrayList<>();

        Map<String,List<String>> mp = new HashMap<>();
        for(String s : strs)
        {
            char[] ca = new char[26];
            for(char ch : s.toCharArray())
            {
                ca[ch - 'a']++;
            }
            String k = String.valueOf(ca);
            if(!mp.containsKey(k))
            mp.put(k,new ArrayList<>());

            mp.get(k).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}