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
            int[] a = new int[n], b = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = new Solution().findSum(a, b);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends
//User function Template for Java
class Solution {
    ArrayList<Integer> findSum(int a[], int b[]) {
        int i = a.length - 1;
        int j = b.length - 1;
        ArrayList<Integer> arr = new ArrayList<>();
        int[] k = new int[Math.max(i, j) + 1];
        int carry = 0;
        int idx = k.length - 1;
        
        while (idx >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a[i];
                i--;
            }
            if (j >= 0) {
                sum += b[j];
                j--;
            }
            carry = sum / 10;
            k[idx] = sum % 10;
            idx--;
        }
        
        if (carry != 0) {
            arr.add(carry);
        }
        
        for (int val : k) {
            arr.add(val);
        }
        
        return arr;
    }
}