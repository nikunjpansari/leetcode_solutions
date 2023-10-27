class Solution {
    public String longestPalindrome(String S) 
    {
        int start = 0 , end = 0 ,len = 0 , n = S.length();
        for(int i = 1 ; i < n ;i++)
        {
            // for Odd length
            int s = i - 1;
            int e = i + 1;
            while(s >= 0 && e < n && S.charAt(s) == S.charAt(e))
            {
                if(e-s+1 > len)
                {
                    len = e-s+1;
                    start = s;
                    end = e;
                }
                s--;
                e++;
            }

            // for Even length
            s = i-1;
            e = i;
            while(s >= 0 && e < n && S.charAt(s) == S.charAt(e))
            {
                if(e-s+1 > len)
                {
                    len = e-s+1;
                    start = s;
                    end = e;
                }
                s--;
                e++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = start ; i <= end ;i++)
        {
            sb.append(S.charAt(i));
        }
        return sb.toString();
    }
}