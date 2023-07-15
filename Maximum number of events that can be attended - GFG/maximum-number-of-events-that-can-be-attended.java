//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            int[] start = new int[N];
            int[] end = new int[N];
            
            for(int i=0; i<N; i++)
            {
                start[i] = Integer.parseInt(S1[i]);
                end[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxEvents(start,end,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
     public static int maxEvents(int[] start, int[] end, int N) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= 100000; i++)
            set.add(i);
        int ans = 0;

        int[][] events = new int[N][2];
        for (int i = 0; i < N; i++) {
            events[i][0] = start[i];
            events[i][1] = end[i];
        }

        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]) return 1;
                else if (a[1] < b[1]) return -1;
                else if (a[0] > b[0]) return 1;
                else if (a[0] < b[0]) return -1;
                else return 0;
            }
        });

        for (int i = 0; i < N; i++) {
            Integer available = set.ceiling(events[i][0]);
            if (available == null || available > events[i][1])
                continue;
            else {
                ans++;
                set.remove(available);
            }
        }
        return ans;
    }
};