//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int arr[], int N)
    {
        int res = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        
        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                res = entry.getKey();
                break; 
            }
        }
        
        return res;
    }
}