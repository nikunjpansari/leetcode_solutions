//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends
class Solution {
    public int romanToDecimal(String str) {
       HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans=0,n=str.length();
        
        for(int i=0;i<n;i++)
        {
            char ch=str.charAt(i);
            
            
            if((i!=n-1)&&map.get(ch)<map.get(str.charAt(i+1)))
            {
                ans+=map.get(str.charAt(i+1))-map.get(ch);
                i++;
            }
            
            else
                ans+=map.get(ch);
        }
        return ans;
    }
}