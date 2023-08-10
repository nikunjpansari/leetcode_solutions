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
            
            int N;
            N = Integer.parseInt(br.readLine().trim());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int Key;
            Key = Integer.parseInt(br.readLine().trim());
            
            Solution obj = new Solution();
            boolean res = obj.Search(N, A, Key);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean Search(int n, int[] arr, int k) 
    {
     
        int low = 0, high = n - 1;
        while (low <= high) 
        {
            int mid = (low + high) / 2;

            if (arr[mid] == k) 
            return true;

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) 
            {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (arr[low] <= arr[mid]) 
            {
                if (arr[low] <= k && k <= arr[mid]) 
                    high = mid - 1;
                else 
                    low = mid + 1;
            } 
            else 
            {
                if (arr[mid] <= k && k <= arr[high]) 
                    low = mid + 1;
                else 
                    high = mid - 1;
            }
        }
        return false;
    
    }
}
        
