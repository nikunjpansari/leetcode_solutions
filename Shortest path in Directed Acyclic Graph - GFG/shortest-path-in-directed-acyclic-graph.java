//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends
// Time Complexity: O(N+M)
// Space Complexity: O(N)
//User function Template for Java
class pair{
    int first,second;
    pair(int a,int b){
        first=a;
        second=b;
    }
}
class Solution {
  	void dfs(int node,boolean vis[],ArrayList<Integer> topo,ArrayList<pair> adj[]){
	    vis[node]=true;
	    for(pair x:adj[node]){
	        if(vis[x.first]==false){
	            dfs(x.first,vis,topo,adj);
	        }
	    }
	    topo.add(node);
	}
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		boolean vis[] = new boolean[N];
		Arrays.fill(vis,false);
	    ArrayList<Integer> topo = new ArrayList<>();
	    ArrayList<pair> adj[]=new ArrayList[N];
	    for(int i=0;i<N;i++) {
			adj[i]=new ArrayList<>();
		}
	    for(int i=0;i<M;i++){
	        adj[edges[i][0]].add(new pair(edges[i][1],edges[i][2]));
	    }
	    for(int i=0;i<N;i++){
	        if(vis[i]==false){
	            dfs(i,vis,topo,adj);
	        }
	    }
	    Collections.reverse(topo);
	    int dis[] = new int[N];
	    Arrays.fill(dis,Integer.MAX_VALUE);
	    dis[0]=0;
	    for(int i=0;i<N;i++){
	        if(dis[topo.get(i)]!=Integer.MAX_VALUE){
	            for(pair x:adj[topo.get(i)]){
	                if(dis[topo.get(i)]+x.second<dis[x.first]){
	                    dis[x.first]=dis[topo.get(i)]+x.second;
	                }
	            }
	        }
	    }
	    for(int i=0;i<N;i++){
	        if(dis[i]==Integer.MAX_VALUE)dis[i]=-1;
	    }
	    return dis;
	}
}