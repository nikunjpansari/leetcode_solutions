class Solution {
   public int maxLengthBetweenEqualCharacters(String s) 
   {
    int res = -1; 
    for (int i = 0; i < s.length() - 1; i++) 
    {
        char c = s.charAt(i);
        for (int j = s.length() - 1; j > i; j--) 
        {
            if (c == s.charAt(j)) 
            {
                res = Math.max(res, j - i - 1);
                break; 
            }
        }
    }
    return res;
}
}