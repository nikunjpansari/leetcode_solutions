class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] tmp = new int[1001];
        for(int i : nums1)
        {
        if(tmp[i] != 1)
        tmp[i] = 1;
        }
        int cnt = 0;
        for(int i : nums2)
        {
            if(tmp[i] == 1)
            {
                tmp[i] = 2;
                cnt+=1;
            }
        }

        int[] res = new int[cnt];
        int j = 0;
        for(int i = 0 ;i < tmp.length;i++)
        {
            if(tmp[i] == 2)
            res[j++] = i;
        }

        return res;
    }
}