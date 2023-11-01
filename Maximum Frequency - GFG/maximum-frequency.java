//{ Driver Code Starts
//Initial Template for Java

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n;
            n = Integer.parseInt(st.nextToken());
            int[] arr = IntArray.input(br, n);
            
            int k;
            k = Integer.parseInt(st.nextToken());
            
            Solution obj = new Solution();
            int res = obj.maxFrequency(arr, n, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends
class Solution {
    public static int maxFrequency(int[] arr, int n, int k) 
    {
        Arrays.sort(arr);
        int i =0 , j = 0;
        int res = 1;
        long sum = 0 ;
        while(j < n)
        {
            sum += arr[j];
            while(sum + k < (j-i+1)*arr[j])
            {
                sum -= arr[i];
                i++;
            }
            res = Math.max(res,j-i+1);
            j++;
        }
    return res;
    }
}
