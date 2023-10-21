class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{-1,0});

        int res = Integer.MIN_VALUE;

        for(int i = -k , j= 0 ; j != nums.length;i++,j++)
        {
            final int ans = Math.max(0,dq.peekFirst()[1]) + nums[j];
            res = Math.max(res,ans);

            while(!dq.isEmpty() && dq.peekLast()[1] <= ans)
            {
            dq.pollLast();
            }
            dq.offerLast(new int[]{j,ans});
            if(dq.peekFirst()[0] == i)
            dq.pollFirst();
        }
        return res;
    }
}