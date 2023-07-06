//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int rows=sc.nextInt();
       		int columns=sc.nextInt();
			
			int matrix[][]=new int[rows][columns];
          
        	for(int i=0; i<rows;i++){            
            	for(int j=0; j<columns;j++){
                	matrix[i][j]=sc.nextInt();
            	}
         	}
         	int target = sc.nextInt();
         	
			Solution x = new Solution();
			
			if (x.search(matrix, rows, columns, target)) 
				System.out.println(1); 
			else
				System.out.println(0); 
			t--;
		}
	} 
}
// } Driver Code Ends




class Solution 
{ 
    //Function to search a given number in row-column sorted matrix.
	public static boolean search(int matrix[][], int n, int m, int x) {
    for (int i = 0; i < n; i++) {
        int l = matrix[i][0];
        int h = matrix[i][m - 1];
        if (l == x || h == x) {
            return true;
        }
        if (x > l && x < h) {
            for (int j = 0; j < m - 1; j++) {
                if (matrix[i][j] == x) {
                    return true;
                }
            }
        } else {
            continue;
        }
    }
    return false;
}

} 
