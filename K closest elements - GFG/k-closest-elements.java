//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
         
        int[]res=new int[k];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]!=x)
            pq.add(new int[]{Math.abs(x-arr[i]),arr[i]});
        }
        
        int idx=0;
        
        while(!pq.isEmpty() && k-->0)
        {
            int[]temp=pq.poll();
            res[idx++]=temp[1];
        }
        return res;
    }
}
