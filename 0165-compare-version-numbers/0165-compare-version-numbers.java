class Solution {
    public int compareVersion(String a, String b) 
    {
        for (int i = 0, j = 0, m, n; i < a.length() || j < b.length(); i++, j++) 
        {
            m = n = 0;
            while (i < a.length() && a.charAt(i) != '.') 
            m = m * 10 + a.charAt(i++) - '0';
            while (j < b.length() && b.charAt(j) != '.') 
            n = n * 10 + b.charAt(j++) - '0';

            if (m > n) 
            return 1;

            if (m < n) 
            return -1;
        }
        return 0;
}
}