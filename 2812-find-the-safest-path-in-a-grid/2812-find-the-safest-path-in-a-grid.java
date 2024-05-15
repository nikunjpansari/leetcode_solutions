class Solution {
    private final int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    private int n;
    private int[][] sFGrid;
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        sFGrid =  new int[n][n];
        int maxDist = calculateSFforGrid(grid);

        int left = 0, right = maxDist;
        int ans = 0;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (checkIfPossible(mid)){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return ans;
    }

    private boolean checkIfPossible(int val){

        boolean[][] visited = new boolean[n][n];
        Deque<int[]> queue = new LinkedList<>();
        if (sFGrid[0][0] < val)
            return false;
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] pos= queue.poll();
            int r = pos[0], c = pos[1];

            if ( r == n - 1 && c == n - 1)
                return true;

            for (int[] dir : dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && 
                    sFGrid[nr][nc] >= val) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }

    private int calculateSFforGrid(List<List<Integer>> grid){
        boolean[][] visited = new boolean[n][n];

        Deque<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int currDist = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];
                sFGrid[r][c] = currDist;
                for(int[] d : dirs){
                    int nr = r + d[0], nc = c + d[1];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]){
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            currDist++;
        }
        return currDist;
    }
}