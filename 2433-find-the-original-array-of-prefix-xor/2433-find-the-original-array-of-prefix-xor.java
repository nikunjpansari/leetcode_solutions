class Solution {
    public int[] findArray(int[] pref) {
        int n=pref.length;
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            if(i==0)
                a[i]=pref[i];
            else
                a[i]=pref[i]^pref[i-1];
                
        }
        return a;
    }
}