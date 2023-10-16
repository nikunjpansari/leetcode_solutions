// Time Complexity : O(k)
// Space Complexity : O(k)
class Solution {
    public List<Integer> getRow(int k) 
    {
        List<Integer> row = new ArrayList<>();

        long ans = 1;
        row.add((int) ans); 
        
        for (int i = 1; i <= k; i++) 
        {
            ans = ans * (k - i + 1) / i;
            row.add((int) ans);
        }

        return row;
    }
}