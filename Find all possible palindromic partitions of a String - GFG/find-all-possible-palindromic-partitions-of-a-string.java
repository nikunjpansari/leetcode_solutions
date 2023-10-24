//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends

class Solution 
{
    static ArrayList<ArrayList<String>> allPalindromicPerms(String s) 
    {
       ArrayList<ArrayList<String>> res = new ArrayList<>();
       ArrayList<String> path = new ArrayList<>();
       func(0,s,path,res);
       return res;
    }
    static void func(int index,String s,ArrayList<String> path,ArrayList<ArrayList<String>> res)
    {
        if(index == s.length())
        {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=index;i<s.length();++i)
        {
            if(isPalindrome(s,index,i))
            {
            path.add(s.substring(index,i+1));
            func(i+1,s,path,res);
            path.remove(path.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s,int st,int e)
    {
    while(st <= e)
    {
        if(s.charAt(st++) != s.charAt(e--))
        return false;
    }
    return true;
    }
};