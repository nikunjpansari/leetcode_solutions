class Solution {
    
    private long fn(int u, int p, List<Integer>[] tree, int[] values, int k) {
        for (var v : tree[u]) 
            if (v != p) values[u] = (int) ((values[u] + fn(v, u, tree, values, k)) % k); 
        return values[u]; 
    }
    
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] tree = new ArrayList[n]; 
        Arrays.setAll(tree, x -> new ArrayList()); 
        for (var e : edges) {
            tree[e[0]].add(e[1]); 
            tree[e[1]].add(e[0]); 
        }
        fn(0, -1, tree, values, k); 
        return (int) IntStream.of(values).filter(x -> x % k == 0).count(); 
    }
}