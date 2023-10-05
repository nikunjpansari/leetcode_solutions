//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) 
    {
    int aCnt = -1, bCnt = -1, cCnt = -1;
    int count = 0;

    for (int i = 0; i < s.length(); i++) 
    {
        char currentChar = s.charAt(i);

        if (currentChar == 'a') 
            aCnt = i;
        else if (currentChar == 'b')
            bCnt = i;
        else if (currentChar == 'c')
            cCnt = i;

        if (aCnt != -1 && bCnt != -1 && cCnt != -1) 
            count += Math.min(Math.min(aCnt, bCnt), cCnt) + 1;
    }

    return count;
}
}
        
