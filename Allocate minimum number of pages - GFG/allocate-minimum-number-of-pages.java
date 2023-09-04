//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
   public static int findPages(int[] A, int N, int M) {
    // Book allocation impossible
    if (M > N) {
        return -1;
    }

    int low = Arrays.stream(A).max().getAsInt();
    int high = Arrays.stream(A).sum();
    while (low <= high) {
        int mid = (low + high) / 2;
        int students = countStudents(A, mid);
        if (students > M) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return low;
}

public static int countStudents(int[] A, int pages) {
    int N = A.length;
    int students = 1;
    long pagesStudent = 0;
    for (int i = 0; i < N; i++) {
        if (pagesStudent + A[i] <= pages) {
            // Add pages to the current student
            pagesStudent += A[i];
        } else {
            // Add pages to the next student
            students++;
            pagesStudent = A[i];
        }
    }
    return students;
}

};