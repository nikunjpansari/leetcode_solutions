//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.smallestNumber(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String smallestNumber(int S, int D){
         String ans = "";
        char arr[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        while(D > 0){
            int cal = S-D+1;
            
            if(S > 9)
            {
                ans = '9' + ans;
                S = S-9;
            }
            else if( S <=9 && D != 1)
            {
                ans = arr[S-1] + ans;
                S = 1;
            }
            else if( S<=9 && D == 1)
            {
                ans = arr[S] + ans;
                S = 0;
            }
            else if( S == 1 && D != 1)
                ans = '0' + ans;
           
            D--;
        }
        
        if(S !=0) 
        
        return "-1";
        
        return ans;
    }
}