//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
   public static long getMaxArea(long hist[], long n) {
        Stack<Long> st = new Stack<>();
        long maxA = 0;
        
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || hist[st.peek().intValue()] >= hist[i])) {
                long height = hist[st.peek().intValue()];
                st.pop();
                long width;
                if (st.empty()) {
                    width = i;
                } else {
                    width = i - st.peek().intValue() - 1;
                }
                maxA = Math.max(maxA, width * height);
            }
            st.push((long) i);
        }
        
        return maxA;
    }
    
        
}



