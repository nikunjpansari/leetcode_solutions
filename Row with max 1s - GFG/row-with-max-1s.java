//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int rowWithMax1s(int[][] matrix, int n, int m) {
        int cnt_max = 0;
        int index = -1;
        
        for (int i = 0; i < n; i++) {
            int cnt_ones = m - lowerBound(matrix[i], m, 1);
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        
        return index;
    }

    private int lowerBound(int[] arr, int n, int x)
    {
        long start = 0;
        long end = n - 1;
        long result = n;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (arr[(int) mid] >= x) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return (int) result;
    }
}