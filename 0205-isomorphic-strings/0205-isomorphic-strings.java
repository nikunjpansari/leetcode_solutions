class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
        return false;

        Map<Character,Character> mp = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++)
        {
            if(mp.containsKey(s.charAt(i)))
            {
                if(mp.get(s.charAt(i)) != t.charAt(i))
                return false;
            }
            else
            {
                if(mp.containsValue(t.charAt(i)))
                return false;
            }
            mp.put(s.charAt(i),t.charAt(i));
        }
        return true;
    }
}