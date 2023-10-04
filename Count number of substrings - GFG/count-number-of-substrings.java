//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends

class Solution
{
   public long substrCount(String s, int k) {
        int n = s.length();
        long ans = ok(s, k, n) - ok(s, k - 1, n);
        return ans;
    }

    private long ok(String s, int k, int n) {
        int i = 0, j = 0;
        int[] mp = new int[26];
        long ans = 0;
        int distinct = 0;

        while (j < n) {
            mp[s.charAt(j) - 'a']++;
            if (mp[s.charAt(j) - 'a'] == 1) {
                distinct++;
            }

            while (distinct > k) {
                if (mp[s.charAt(i) - 'a'] == 1) {
                    distinct--;
                    mp[s.charAt(i) - 'a']--;
                } else {
                    mp[s.charAt(i) - 'a']--;
                }
                i++;
            }

            ans += (j - i + 1);
            j++;
        }

        return ans;
    }
}