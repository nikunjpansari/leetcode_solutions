//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    boolean checkIsAP(int arr[] ,int n)
    {
       Arrays.sort(arr);
       int d = 0;
       boolean flag = false;
       for(int i = 1 ; i <n;i++)
       {
           if(i == 1)
           d = Math.abs(arr[i] - arr[i-1]);
           else if(d != Math.abs(arr[i] - arr[i-1]))
           {
               flag = false;
               break;
           }
           if( i + 1 == n)
           flag = true;
       }
    return flag;
    
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            int n=Integer.parseInt(br.readLine());

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[]=new int[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(a1[i]);
            }
            Solution ob=new Solution();

            boolean ans=ob.checkIsAP(a,n);
            if(ans==true)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}




// } Driver Code Ends