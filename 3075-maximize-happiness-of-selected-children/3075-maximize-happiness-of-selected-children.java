class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int n = happiness.length;
        for(int i = n-1,j=0;i>=0 && k> 0;--i,j++,k--)
        {
            if(happiness[i] - j > 0)
            res += happiness[i] - j;
        }
        return res;
    }
}