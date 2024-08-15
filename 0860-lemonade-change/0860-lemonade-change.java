class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f = 0;
        int t = 0;
        for(Integer b : bills)
        {
            if(b==5)
            f++;
            else if(b==10)
            {
                t++;
                f--;
            }
            else if(t>0)
            {
                t--;
                f--;
            }
            else
            f-=3;
            if(f<0)
        return false;
        }
        return true;
    }
}