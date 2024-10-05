class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        
        if (n1 > n2) return false;

        HashMap<Character, Integer> ctr1 = new HashMap<>(), ctr2 = new HashMap<>();
        
        for (int i = 0; i < n1; ++i) {
            ctr1.put(s1.charAt(i), ctr1.getOrDefault(s1.charAt(i), 0) + 1);
            ctr2.put(s2.charAt(i), ctr2.getOrDefault(s2.charAt(i), 0) + 1);}

        for (int i = n1; i < n2; ++i) {
            if (ctr1.equals(ctr2)) return true;
            
            char oldChar = s2.charAt(i - n1);
            ctr2.put(oldChar, ctr2.get(oldChar) - 1);
            if (ctr2.get(oldChar) == 0) ctr2.remove(oldChar);  
            char newChar = s2.charAt(i);
            ctr2.put(newChar, ctr2.getOrDefault(newChar, 0) + 1);}
        return ctr1.equals(ctr2); 
    }
}