class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int tmp = n;
        while(n > 0){
            int r = n % 10;
            n /= 10;
            sum += r;
            prod *= r;
        }
        if(tmp % (sum + prod) == 0)
        return true;
        else
        return false;
    }
}