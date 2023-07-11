//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	int rl=0,ru=n-1,cl=0,cu=m-1,count=0;
     		while(count!=n*m){
     		    for(int i=cl;i<=cu;i++){
     		        count++;
     		        if(count==k)return A[rl][i];
     		    }
     		    rl++;
     		    for(int i=rl;i<=ru;i++){
     		        count++;
     		        if(count==k)return A[i][cu];
     		    }
     		    cu--;
     		    for(int i=cu;i>=cl;i--){
     		        count++;
     		        if(count==k)return A[ru][i];
     		    }
     		    ru--;
     		    for(int i=ru;i>=rl;i--){
     		        count++;
     		        if(count==k)return A[i][cl];
     		    }
     		    cl++;
     		}
     		return 0;	
    }
}