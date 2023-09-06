//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
   public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] vis = new boolean[V];
    int lastVisited = -1;

    for (int i = 0; i < V; i++) {
        if (!vis[i]) {
            lastVisited = i;
            dfs(i, vis, adj);
        }
    }

    // Check if the last visited vertex is a mother vertex
    Arrays.fill(vis, false);
    dfs(lastVisited, vis, adj);
    
    for (int i = 0; i < V; i++) {
        if (!vis[i]) {
            return -1;
        }
    }

    return lastVisited;
}

private void dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
    vis[i] = true;
    for (int j : adj.get(i)) {
        if (!vis[j]) {
            dfs(j, vis, adj);
        }
    }
}

}