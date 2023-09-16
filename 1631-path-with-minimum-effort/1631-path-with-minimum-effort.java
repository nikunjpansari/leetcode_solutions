class Solution {
     public int minimumEffortPath(int[][] h) {
            int R = h.length;
            int C = h[0].length;
            Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            boolean[][] visited = new boolean[R][C];
            q.add(new int[]{0, 0, 0});
            int[][] cost = new int[R][C];
            for (int i = 0; i < R; i++)
                Arrays.fill(cost[i], Integer.MAX_VALUE);

            cost[0][0] = 0;

            while (q.size() > 0) {
                int x = q.peek()[0];
                int y = q.peek()[1];
                int w = q.peek()[2];
                q.poll();
                visited[x][y] = true;
                int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                        int maxCost = Math.max(Math.abs(h[x][y] - h[nx][ny]), cost[x][y]);
                        if (maxCost < cost[nx][ny]) {
                            cost[nx][ny] = maxCost;
                            q.add(new int[]{nx, ny, cost[nx][ny]});
                        }
                    }
                }
            }

            return cost[R - 1][C - 1];
        }
}