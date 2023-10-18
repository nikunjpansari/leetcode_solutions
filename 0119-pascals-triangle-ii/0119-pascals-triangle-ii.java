class Solution {
    public List<Integer> getRow(int k) {
        List<Integer> res = new ArrayList<>();
        long ans = 1;
        res.add((int) ans);

        for(int i = 1 ; i<=k;i++)
        {
            ans = ans * (k-i+1)/i;
            res.add((int) ans);        
        }
        return res;
    }
}