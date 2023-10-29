class Solution {
        public long minSum(int[] nums1, int[] nums2) 
        {
        long s1 = 0, s2 = 0, a0 = 0, a1 = 0;

        for (int a: nums1) 
        {
            a0 += a > 0 ? 0: 1;
            s1 += Math.max(a, 1);
        }
        for (int b: nums2) 
        {
            a1 += b > 0 ? 0: 1;
            s2 += Math.max(b, 1);
        }
        if (s1 < s2 && a0 == 0) 
        return -1;

        if (s1 > s2 && a1 == 0) 
        return -1;
        return Math.max(s1, s2);
    }
}