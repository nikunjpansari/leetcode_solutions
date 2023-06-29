class Solution {
    public int bulbSwitch(int n) {
         double a=0;
        if(n==0 || n==1)
            return n;
        if(n>1)
            a=Math.sqrt(n);
       a=Math.floor(a); 
       int m=(int)Math.round(a);
       return m;
    }
}