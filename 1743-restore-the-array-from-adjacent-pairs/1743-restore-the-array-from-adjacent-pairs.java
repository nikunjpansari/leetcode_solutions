class Solution {
    public int[] restoreArray(int[][] adjacentPairs) 
    {
           Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int[] pair : adjacentPairs) 
        {
            mp.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            mp.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        int n = adjacentPairs.length + 1;
        int[] ans = new int[n];

        int start = 0;
        for (int key : mp.keySet()) 
        {
            if (mp.get(key).size() == 1) 
            {
                start = key;
                break;
            }
        }

        ans[0] = start;
        ans[1] = mp.get(start).get(0);

        for (int i = 2; i < n; i++) 
        {
            List<Integer> ls = mp.get(ans[i - 1]);
            ans[i] = (ans[i - 2] == ls.get(0)) ? ls.get(1) : ls.get(0);
        }

        return ans;
    }
}