class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        long[] pre = new long[n+1];
        for(int i = 0 ; i < n ;i++)
        {
            pre[i+1] = pre[i] + nums[i]; 
        }
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0 ;i <= n;i++)
        {
            while(!q.isEmpty() && pre[i] <= pre[q.peekLast()])
            {
                q.removeLast();
            }
            while(!q.isEmpty() && pre[i] - pre[q.peekFirst()]>= k)
            {
                res = Math.min(res,i - q.removeFirst());
            }
            q.offerLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}