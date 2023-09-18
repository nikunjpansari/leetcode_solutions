class Solution {
    public int[] kWeakestRows(int[][] mat, int k) 
    {
    int m = mat.length;
    int n = mat[0].length;

    List<int[]> res = new ArrayList<>();

    for (int i = 0; i < m; i++) 
    {
        int cnt = 0;
        for (int j = 0; j < n; j++) 
        {
            if (mat[i][j] == 1) 
                cnt += 1;
        }
        res.add(new int[]{i, cnt}); 
    }
    res.sort(Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));

    int[] ans = new int[k];

    for (int j = 0; j < k; j++) {
        ans[j] = res.get(j)[0];
    }

    return ans;
    }
}