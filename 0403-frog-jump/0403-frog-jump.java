class Solution {
    public boolean canCross(int[] stones) {
      int n=stones.length;
      Set<Integer> dp [] =new Set[n];
        for(int i=0;i<n;i++)
            dp[i]=new HashSet<>();
        dp[0].add(0);
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                int t=stones[i]-stones[j];
                if(dp[j].contains(t)||dp[j].contains(t-1)||dp[j].contains(t+1))
                    dp[i].add(t);
            }
        }
        if(dp[n-1].size() > 0)
        return true;
        return false;
    }
}