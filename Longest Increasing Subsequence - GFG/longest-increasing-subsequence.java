//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends

// Time Complexity : O(N * log N)
// Space Complexity : O(N)
class Solution 
{
    static int longestSubsequence(int n, int arr[])
    {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);

        int len = 1;

        for (int i = 1; i < n; i++) 
        {
            if (arr[i] > ans.get(ans.size() - 1)) 
            {
                ans.add(arr[i]);
                len++;
            } 
            else 
            {
                int indx = binarySearch(ans, arr[i]);
                ans.set(indx, arr[i]);
            }
        }
        return len;
    }
    
    static int binarySearch(ArrayList<Integer> ans, int key) 
    {
        int low = 0;
        int high = ans.size() - 1;
        while (low <= high) 
        {
            int mid = low + (high - low) / 2;
            if (ans.get(mid) == key) return mid;
            else if (ans.get(mid) < key) 
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return high + 1;
    }
}