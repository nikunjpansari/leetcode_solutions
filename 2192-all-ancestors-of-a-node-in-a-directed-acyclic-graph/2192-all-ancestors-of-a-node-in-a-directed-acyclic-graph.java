class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) 
    {
    List<List<Integer>> ans = new ArrayList();
    List<List<Integer>> res = new ArrayList();

    for (int i = 0; i < n; i++) 
    {
        ans.add(new ArrayList());
        res.add(new ArrayList());
    }
    for (int[] e: edges) 
        res.get(e[0]).add(e[1]);
    for (int i = 0; i < n; i++) 
        dfs(i, i, ans, res);
    return ans;
}
private void dfs(int x, int curr, List<List<Integer>> ans, List<List<Integer>> res) 
{
    for (int ch: res.get(curr))
        if(ans.get(ch).size() == 0 || ans.get(ch).get(ans.get(ch).size() - 1) != x) 
        {
            ans.get(ch).add(x);
            dfs(x, ch, ans, res);
        }
}
}