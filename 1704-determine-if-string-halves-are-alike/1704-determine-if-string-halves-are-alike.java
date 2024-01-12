class Solution {
    public boolean halvesAreAlike(String s) {
        String s1 = s.toLowerCase();
        int n = s1.length();

        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 0 ; i < n/2 ;i++)
        {
            if(s1.charAt(i) == 'a' || s1.charAt(i) == 'e' || s1.charAt(i) == 'i' || s1.charAt(i) == 'o' || s1.charAt(i) == 'u')
            {
                cnt1 += 1;
            }
        }

        for(int i = n/2 ; i < n ;i++)
        {
            if(s1.charAt(i) == 'a' || s1.charAt(i) == 'e' || s1.charAt(i) == 'i' || s1.charAt(i) == 'o' || s1.charAt(i) == 'u')
            {
                cnt2 += 1;
            }

        }
        
            if(cnt1 == cnt2)
            return true;
            else
            return false;
    }
}