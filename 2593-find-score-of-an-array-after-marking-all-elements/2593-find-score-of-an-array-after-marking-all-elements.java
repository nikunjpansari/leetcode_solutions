class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a,b) -> a[0] == b[0] ? a[1] -b [1] : a[0] -b [0]
        ); 
        for(int i=0;i<nums.length;i++)
        {
            pq.offer(new int[] {nums[i], i});
        }
        Set<Integer> set = new HashSet<>();
        long res =0;
        while(!pq.isEmpty() && set.size()!= nums.length)
        {
            int[] t = pq.poll();
            if(set.contains(t[1]))
                continue;
            res += t[0];
            if(t[1] - 1 >= 0)
                set.add(t[1] - 1);
             if(t[1] + 1 < nums.length)
                set.add(t[1] + 1);
        }
        return res;
    }
}