//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            
            int l=sc.nextInt();
			int r=sc.nextInt();
			Solution ob = new Solution();
			ArrayList<Integer> numbers = ob.uniqueNumbers(l,r);
			for(int num : numbers){
			    System.out.print(num+" ");
			}
			System.out.println();

        }
    }
}

// } Driver Code Ends

class Solution
{
    static ArrayList<Integer> uniqueNumbers(int L,int R)
    {
        ArrayList<Integer>  res = new ArrayList<>();
            for(int i=L;i<=R;i++)
            {
            if(isValid(i))
            res.add(i);
        }
        return res;
    }
    
    static boolean isValid(int num)
    {
        Set<Integer> set = new HashSet<>();
        while(num>0){
            int rem = num % 10;
            if(!set.add(rem))
            return false;
            
            num = num /10;
        }
        return true;
    }
}