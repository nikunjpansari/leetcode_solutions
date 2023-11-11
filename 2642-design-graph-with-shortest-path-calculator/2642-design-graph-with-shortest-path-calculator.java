class Graph {
    
    private int n; 
    private List<int[]>[] edges; 
    private int INF = Integer.MAX_VALUE; 
    
    public Graph(int n, int[][] edges) {
        this.n = n;
        this.edges = new List[n];
        for (int i = 0; i < n; i++) {
            this.edges[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];
        edges[u].add(new int[]{v, w});
    }
    
    public int shortestPath(int node1, int node2) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[node1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{node1, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            if (d > dist[u]) {
                continue;
            }
            for (int[] edge : edges[u]) {
                int v = edge[0];
                int w = edge[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist[node2] == INF ? -1 : dist[node2];
    }
}