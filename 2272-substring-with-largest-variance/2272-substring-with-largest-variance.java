// Time Complexity : O(26*26*N)
// Space Complexity : O(1)
class Solution {
    public int largestVariance(String s) 
    {
        int res = 0;
        for(int high=0;high<26;high++)
        { 
            for(int low=0;low<26;low++)
            {
                if(high==low) 
                continue;  
                int currHigh=0, currLow=0;

                boolean windowShrinked = false;

                for(int i=0; i<s.length(); i++)
                {
                    int ch = s.charAt(i)-'a';
                    if(ch == high) currHigh++;
                    else if(ch == low) currLow++;
                    
                    if(currHigh>0 && currLow>0)
                        res = Math.max(res, currHigh-currLow);
             
                    else if(currHigh>0 && windowShrinked)
                        res = Math.max(res, currHigh-1);
                 
                    if(currLow>currHigh)
                    { //window shrinked 
                        windowShrinked = true;
                        currLow = 0;
                        currHigh = 0;
                    }
                }
            }
        }
        
        return res;
    }
}