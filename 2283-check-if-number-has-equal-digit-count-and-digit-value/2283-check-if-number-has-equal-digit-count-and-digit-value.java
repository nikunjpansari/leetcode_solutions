class Solution {
    public boolean digitCount(String num) {
        int[] a = new int[10];

        for(int i = 0 ; i< num.length();i++)
        a[num.charAt(i) - '0']++;

        for(int i = 0 ; i < num.length();i++)
        { 
        if(a[i] != num.charAt(i) - '0')
        return false;
        }
        return true;
    }
}