class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] f = new int[26];
        for(char c : tasks)
        {
            f[c - 'A']++;
        }
        Arrays.sort(f);
        int chunk= f[25]-1;
        int idlespots = chunk*n;
        for(int i = 24 ;i>=0;i--)
        {
            idlespots -= Math.min(chunk,f[i]);
        }
        return idlespots < 0 ? tasks.length : idlespots+tasks.length;
    }
}