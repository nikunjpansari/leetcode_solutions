class Solution {
    public int minChanges(String s) {
        char[] a = s.toCharArray();
        int res = 0;
        for(int i = 1 ; i < s.length() ;i+=2)
        {
            if(a[i] != a[i-1])
            res+=1;
        }
        return res;
    }
}