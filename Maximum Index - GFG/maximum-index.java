//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
         int min[]=new int[n];
        int max[]=new int[n];
        min[0]=arr[0];
        max[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            min[i]=Math.min(min[i-1],arr[i]);
        }
        for(int j=n-2;j>=0;j--){
            max[j]=Math.max(max[j+1],arr[j]);
        }
        int res=0;
        int i=0,j=0;
        while(i<n && j<n){
            if(min[i]<=max[j]){
                res=Math.max(res,j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return res;
    }
}