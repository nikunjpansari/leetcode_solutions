//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            String inputLine[] = br.readLine().trim().split(" "); 
            int n = Integer.parseInt(inputLine[0]); 
            int x = Integer.parseInt(inputLine[1]);
            
            int arr[] = new int[(int)(n)];
            
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine1[i]);
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.firstAndLast(arr, n, x); 
            
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    } 
} 
            



// } Driver Code Ends


//User function Template for Java
class Solution{
    public ArrayList<Integer> firstAndLast(int arr[], int n, int x){
       ArrayList<Integer> res = new ArrayList<>();
       if(solve(arr,x,true) == -1)
       res.add(-1);
       else
       {
           res.add(solve(arr,x,true));
            res.add(solve(arr,x,false));
       }
       
       return res;
    }
    public int solve(int arr[],int x,boolean indx)
    {
        int ans =-1;
        int l = 0 ;
        int h = arr.length - 1;
        while(l <= h)
        {
            int mid = l + (h-l)/2;
            if(x <  arr[mid])
            h = mid - 1;
            else if(x > arr[mid])
            l = mid + 1;
            else
            {
                ans = mid;
                if(indx)
                    h = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return ans;
    }
}
