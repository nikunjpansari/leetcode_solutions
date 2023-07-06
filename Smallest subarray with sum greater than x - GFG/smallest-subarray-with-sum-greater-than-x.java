//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java
// Time Complexity: O(N)
// Space Complexity : O(1)

class Solution {

    int smallestSubWithSum(int arr[], int n, int x)
    {
    int i  = 0 , j = 0;
    int curr_sum = 0;
    int ans = Integer.MAX_VALUE;
    
    while(j<n) 
    {
        curr_sum += arr[j];
        // curr_sum>x reduce the size
        while(i<j && curr_sum>x) {
            curr_sum -= arr[i];
            ans = Math.min(ans, j-i+1);
            i++;
        }
        if(curr_sum>x)
            ans = Math.min(ans, j-i+1);
        j++;
    }
    return (ans==Integer.MAX_VALUE) ? 1 : ans;
}


}

