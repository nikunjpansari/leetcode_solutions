class Solution {
    public int minimumLength(String s) 
    {
        int i = 0, j = s.length()-1;
        while(i < j)
        {
            if(s.charAt(i) == s.charAt(j))
            {
                char ch = s.charAt(i);
                while(s.charAt(i) == ch && i < j) 
                i++;
                while(s.charAt(j) == ch && i <= j) 
                j--;          
            }
            else 
            break;
        }
        return j-i+1;
    }
}