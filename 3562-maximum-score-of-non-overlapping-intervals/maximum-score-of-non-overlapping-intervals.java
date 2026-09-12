
public class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = i - 1, ans = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (arr[mid][1] < arr[i][0]) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            prev[i] = ans;
        }
        long[][] dp = new long[n][5];
        @SuppressWarnings("unchecked")
        List<Integer>[][] choice = new ArrayList[n][5];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= 4; k++) {
                if (i > 0) {
                    dp[i][k] = dp[i-1][k];
                    choice[i][k] = new ArrayList<>(choice[i-1][k]);
                } else {
                    dp[i][k] = 0;
                    choice[i][k] = new ArrayList<>();
                }
                if (k > 0) {
                    long val = arr[i][2];
                    List<Integer> candidate = new ArrayList<>();
                    if (prev[i] != -1) {
                        val += dp[prev[i]][k-1];
                        candidate.addAll(choice[prev[i]][k-1]);
                    }
                    candidate.add(arr[i][3]);
                    Collections.sort(candidate); 
                    if (val > dp[i][k] || (val == dp[i][k] && lexicographicallySmaller(candidate, choice[i][k]))) {
                        dp[i][k] = val;
                        choice[i][k] = candidate;
                    }
                }
            }
        }
        long best = 0;
        List<Integer> bestChoice = new ArrayList<>();
        for (int k = 1; k <= 4; k++) {
            List<Integer> cand = choice[n-1][k];
            if (dp[n-1][k] > best || (dp[n-1][k] == best && lexicographicallySmaller(cand, bestChoice))) {
                best = dp[n-1][k];
                bestChoice = cand;
            }
        }
        return bestChoice.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private boolean lexicographicallySmaller(List<Integer> a, List<Integer> b) {
        if (b == null || b.isEmpty()) return true;
        int n = Math.min(a.size(), b.size());
        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
}