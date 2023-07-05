//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

// Time Complexity : O(N)
// Space Complexity : O(1)

class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        
    if(n==0) 
    return 0;
    
    long ahead[]=new long[2];
    long cur[]=new long[2];
    
    //base condition
    ahead[0] = ahead[1] = 0;
    
    long profit=0;
    
    for(int i= n-1; i>=0; i--)
    {
        for(int buy=0; buy<=1; buy++){
            if(buy==0)
            // We can buy the stock
                profit = Math.max(0+ahead[0], -prices[i] + ahead[1]);

            if(buy==1)
            // We can sell the stock
            profit = Math.max(0+ahead[1], prices[i] + ahead[0]);
            cur[buy]  = profit;
        }
        ahead = (long[])(cur.clone());
    }
      
    return (int)cur[0];
    }
}
        
