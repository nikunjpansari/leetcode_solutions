class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tmp = new ArrayList<>();
        int i=0;
        int low = newInterval[0];
        int high = newInterval[1];
        while(i < intervals.length && intervals[i][1] < newInterval[0])
        {
            tmp.add(intervals[i++]);
        }
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            low = Math.min(low,intervals[i][0]);
            high = Math.max(high,intervals[i][1]);
            i++;
        }
        tmp.add(new int[]{low,high});
        while(i < intervals.length){
            tmp.add(intervals[i++]);
        }
        return tmp.toArray(new int[tmp.size()][]);
    }
}