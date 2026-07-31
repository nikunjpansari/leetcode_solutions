class Solution {
    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for(int i = 0 ;i < word.length();i++)
        {
        ++cnt[word.charAt(i) - 'a'];
        }
        int res = 0;
        Arrays.sort(cnt);
        for(int i =0; i <26 ;i++)
        {
            res += (i/8 + 1) * cnt[26-i-1];
        }
        return res;
    }
}