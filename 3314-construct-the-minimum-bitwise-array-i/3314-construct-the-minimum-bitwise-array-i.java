class Solution {
       public int[] minBitwiseArray(List<Integer> A) {
        int n = A.size(), res[] = new int[n];
        for (int i = 0; i < n; i++) 
        {
            int a = A.get(i);
            if (A.get(i) % 2 == 0) 
                res[i] = -1;
            else 
                res[i] = a - ((a + 1) & (-a - 1)) / 2;
        }
        return res;
    }
}