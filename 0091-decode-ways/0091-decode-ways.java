class Solution {
    public int numDecodings(String s) {
        int n1 = 1 , n2 = 1, n3 = 0;
        if(s.length() == 0 || s.charAt(0) == '0')
        return 0;

        for(int i = 2 ;i <= s.length(); i++)
        {
            n3 = 0;
            if(s.charAt(i-1) != '0')
            n3 = n2;

            int num = Integer.parseInt(s.substring(i-2,i));

            if(num>=10 && num<=26)
            n3+= n1;

            n1 = n2;
            n2 = n3;
        }
        return n2;
    }
}