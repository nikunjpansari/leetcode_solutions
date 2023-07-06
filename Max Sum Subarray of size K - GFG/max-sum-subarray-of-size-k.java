//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends

// Time Complexity : O(N)
// Space Complexity : O(1)

//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
       
        long res = 0;
        long mx = Integer.MIN_VALUE;
        
        for(int i=0;i<K;i++)
            res = res + Arr.get(i);
           
        mx = res;
        for(int i= K ; i<N ; i++)
        {
            res = res - Arr.get(i-K) + Arr.get(i);
            mx = Math.max(mx,res);
        }
        
     return mx;
    }
}