//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
import java.lang.*;


class GFG {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine()); // input size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split("\\s+");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    Solve T = new Solve();
            long ans = T.maxArea(arr,n);
            System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solve{
    
    long maxArea(int height[], int len){
        int n = height.length;
        long area = 0;

        if(n==0)
        return 0;
        for(int i=0,j=n-1;i<j;)
        {
            int a = Math.abs(i-j) * Math.min(height[i],height[j]);
            area = area < a ? a :area;

            if(height[i] < height[j])
            i++;
            else if(height[i] > height[j])
            j--;
            else{
                i++;
                j--;
            }
        }
        return area;
        
    }
    
}