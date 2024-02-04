class Solution
{
    public String minWindow(String s, String t) 
    {
        int[] count = new int[128];
        for(char c: t.toCharArray())
            count[c]++;
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while(end < s.length())
        {
            char c1 = s.charAt(end);
            
            if(count[c1] > 0)
                counter--;
            count[c1]--;
            end++;

            while(counter == 0)
            {
                if(minLen > end - start)
                {
                    minLen = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                count[c2]++; 
                if(count[c2] > 0)
                    counter++;
      
                start++;
            }
            
        }
        return minLen == Integer.MAX_VALUE ? "": s.substring(minStart, minStart + minLen);
        
    }
}