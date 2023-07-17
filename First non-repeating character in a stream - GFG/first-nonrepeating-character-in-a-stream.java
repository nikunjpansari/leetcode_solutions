//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends

// Time Complexity : O(N)
// Space Complexity : O(N) 
class Solution
{
    public String FirstNonRepeating(String A)
    {
        HashMap<Character,Integer> mm = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        
        for(int i=0;i<A.length();i++)
        {
            mm.putIfAbsent(A.charAt(i),0);
            mm.put(A.charAt(i),mm.get(A.charAt(i))+1);
            
            if(mm.get(A.charAt(i))==1)
            q.add(A.charAt(i));
            
            while(q.size()!=0 && mm.get(q.peek())>1)
            q.remove();
            
            if(q.size()==0)
            ans.append('#');
            
            else 
            ans.append(q.peek());
        }
        return ans.toString();
    }
}