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
        Map<Character,Integer> mp = new HashMap<>();
        
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        
        int sum = mp.get(str.charAt(str.length() - 1));
        
        for(int i =0 ;i< str.length()-1;i++)
        {
            
        
        if(mp.get(str.charAt(i)) < mp.get(str.charAt(i+1)))
            sum -= mp.get(str.charAt(i));
        else
            sum += mp.get(str.charAt(i));
        } 
        return sum;
    }
}