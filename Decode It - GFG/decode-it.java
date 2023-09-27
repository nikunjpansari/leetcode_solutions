//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t,i;
	    t=Integer.parseInt(br.readLine());
	    while(t-->0){
	        
	        String str=br.readLine();
	        int k=Integer.parseInt(br.readLine());
	        Solution ob = new Solution();
            System.out.println(ob.decodeIt(str, k));
            
	    }
	}
}
// } Driver Code Ends


class Solution{
    static char decodeIt(String s,int k){
         int i = 0;
     long N = 0;
     for(i = 0;N<k;i++)
     {
         N = Character.isDigit(s.charAt(i) ) ? N * (s.charAt(i) - '0')  : N+1;
    }
  
    for(i--;i>0;i--)
    {
        if(Character.isDigit(s.charAt(i)))
        {
            N /= (s.charAt(i) - '0');
            k %= N;
        }
        else
        {
            if(k%N == 0)
            break;

            N--;
        }
    }
        return s.charAt(i);
    }
}