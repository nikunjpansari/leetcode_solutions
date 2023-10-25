//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends

class Solution
{
    static int mod = (int) (Math.pow(10, 9) + 7);
	public int countPartitions(int n, int target, int nums[])
	{
		int sum  = 0;

        for(int i = 0; i<nums.length;i++)
        sum += nums[i];

        if(sum - target < 0 || (sum -  target) % 2 == 1)
        return 0;

        return solve(nums,(sum-target)/2);
    }
    public static int solve(int[] nums,int target)
    {
    int n = nums.length;

    int[] prev = new int[target+1];
    if(nums[0] == 0)
    prev[0] = 2;
    else
    prev[0] = 1;

    if(nums[0] != 0 && nums[0] <= target)
    prev[nums[0]] = 1;

    for(int i = 1; i < n ;i++)
    {
        int[] curr = new int[target+1];
        for(int j = 0 ; j <= target ; j++)
        {
            int notTaken = prev[j];
            int taken = 0;
            if(nums[i] <= j)
            taken = prev[j-nums[i]] ;

            curr[j] = (notTaken + taken) % mod;    
        }
        prev = curr;
    }
    return prev[target];
    }
}