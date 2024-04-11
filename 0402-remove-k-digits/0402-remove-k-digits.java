class Solution {
    public String removeKdigits(String s, int k) {
        if(k >=  s.length() || k == 0)
        return "0";

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++)
        {
            while(ans.length() > 0 && ans.charAt(ans.length()-1) >  s.charAt(i) && k > 0)
            {
                ans.deleteCharAt(ans.length()-1);
                k--;
            }

            if(ans.length() > 0 || s.charAt(i) != '0')
            {
                ans.append(s.charAt(i));
            }
        }


        while(ans.length() > 0 && k > 0)
        {
        ans.deleteCharAt(ans.length()-1);
        k--;
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}