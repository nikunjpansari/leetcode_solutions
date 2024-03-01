class Solution {
    public String maximumOddBinaryNumber(String s) {
        int a = 0,b =0;
        for(char c : s.toCharArray())
        {
            if(c =='1')
            b+=1;
            else
            a+=1;
        }
        return "1".repeat(b-1) + "0".repeat(a) + (b > 0 ? "1" : 0);
    }
}