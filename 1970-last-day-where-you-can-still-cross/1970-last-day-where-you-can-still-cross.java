class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public boolean canWalk(int[][] cells, int row, int col, int dayAt) {
        boolean[][] grid = new boolean[row][col];
        for (int i = 0; i < dayAt; ++i)
            grid[cells[i][0] - 1][cells[i][1] - 1] = true;

        Queue<int[]> q = new LinkedList<>();
        for (int c = 0; c < col; ++c) {
            if (grid[0][c] == false) {
                q.offer(new int[]{0, c});
                grid[0][c] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0], c = pos[1];
            if (r == row - 1)
                return true;
            for (int i = 0; i < 4; ++i) {
                int nr = r + dx[i], nc = c + dy[i];
                if (nr < 0 || nr == row || nc < 0 || nc == col || grid[nr][nc] == true)
                    continue;
                grid[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canWalk(cells, row, col, mid)) {
                ans = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return ans;
    }
}