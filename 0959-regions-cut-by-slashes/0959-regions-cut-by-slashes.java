class Solution {
    private void dfs(int[][] graph, int row, int col) 
    {
		if (row < 0 || row >= graph.length || col < 0 || col >= graph.length || graph[row][col] != 0) 
        	return;
		
		graph[row][col] = 1;
		dfs(graph, row - 1, col);
		dfs(graph, row + 1, col);
		dfs(graph, row, col - 1);
		dfs(graph, row, col + 1);
	}

	public int regionsBySlashes(String[] grid) 
    {
		int n = grid.length;
		int[][] graph = new int[n * 3][n * 3];
		for (int row = 0; row < n; ++row) {
			for (int col = 0; col < n; ++col) {
				if (grid[row].charAt(col) == '/') {
					graph[row * 3][col * 3 + 2] = 1;
					graph[row * 3 + 1][col * 3 + 1] = 1;
					graph[row * 3 + 2][col * 3] = 1;
				} else if (grid[row].charAt(col) == '\\') {
					graph[row * 3][col * 3] = 1;
					graph[row * 3 + 1][col * 3 + 1] = 1;
					graph[row * 3 + 2][col * 3 + 2] = 1;
				}
			}
		}
		int regions = 0;
		for (int row = 0; row < n * 3; ++row) {
			for (int col = 0; col < n * 3; ++col) {
				if (graph[row][col] != 1) {
					dfs(graph, row, col);
					regions++;
				}
			}
		}
		return regions;
	}
}