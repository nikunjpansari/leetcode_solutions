//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    public int subsequenceCount(String S, String T) {
    int n = S.length();
    int m = T.length();
    int mod = 1000000007;

    int[] prev = new int[n + 1];
    int[] curr = new int[m + 1];

    prev[0] = curr[0] = 1;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (S.charAt(i - 1) == T.charAt(j - 1)) {
                curr[j] = (prev[j - 1] + prev[j]) % mod;
            } else {
                curr[j] = prev[j] % mod;
            }
        }
        prev = curr.clone();
    }

    return prev[m] % mod;
}

}