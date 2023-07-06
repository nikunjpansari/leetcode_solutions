//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
           ArrayList<Integer> ans = new ArrayList<>();
        int start =0;
        int end = 0;
        int sum =0;
        int sum1 =0;
        int j =0;
        int flag = 0;
        for(int i =0; i<n; i++)
        {
            if(a[i]>=0)
            {
                flag =1;
                sum1 = sum1 + a[i];
            }
            else
            {
                if(sum<sum1 || (sum==sum1&&end-start<i-1-j) || (sum==sum1&&end-start==i-1-j&&a[start]>a[j]))
                {
                    start =j;
                    end = i-1;
                    sum = sum1;
                }
                j = i+1;
                sum1 =0;
            }
            if(i == n-1)
            {
                if(sum1>sum || (sum1==sum && end-start<n-1-j) || (sum==sum1&&end-start==i-1-j&&a[start]>a[j]))
                {
                    end = n-1;
                    start = j;
                }
            }
        }
        if(flag==0)
        {
            int temp = -1;
            ans.add(temp);
            return ans;
        }
        for(int i = start; i<=end; i++)
        {
            ans.add(a[i]);
        }
        
        return ans;
    }
}