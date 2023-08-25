class Solution {
     public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3) 
            return false;
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int l = i + j - 1;
                if (i == 0 && j == 0) 
                    dp[i][j] = true;
                else if (i == 0) 
                    dp[i][j] = (s2.charAt(j - 1) == s3.charAt(l)) && dp[i][j - 1];
                else if (j == 0)
                    dp[i][j] = (s1.charAt(i - 1) == s3.charAt(l)) && dp[i - 1][j];
                else 
                    dp[i][j] = ((s1.charAt(i - 1) == s3.charAt(l)) && dp[i - 1][j])
                            || ((s2.charAt(j - 1) == s3.charAt(l)) && dp[i][j - 1]);
                
            }
        }
        
        return dp[len1][len2];
    }

}