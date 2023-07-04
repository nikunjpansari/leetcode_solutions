// Time Complexity : O(N*logN) + O(N) ~ O(N)
// Space Complexity : O(N)
class Solution {
        public int[][] merge(int[][] intervals) {
    int n = intervals.length; // size of the array
    // Sort the given intervals:
    Arrays.sort(intervals, new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    });

    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        // If the current interval does not
        // overlap with the last interval:
        if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)) {
            ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
        }
        // If the current interval overlaps with the last interval:
        else {
            ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));
        }
    }

    // Convert List<List<Integer>> to int[][]
    int[][] mergedIntervals = new int[ans.size()][2];
    for (int i = 0; i < ans.size(); i++) {
        mergedIntervals[i][0] = ans.get(i).get(0);
        mergedIntervals[i][1] = ans.get(i).get(1);
    }

    return mergedIntervals;
}

}