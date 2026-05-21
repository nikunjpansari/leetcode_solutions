class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Map<String,Integer> mp = new HashMap<>();
        for(int i : arr1)
        {
            String num = Integer.toString(i);
            String pre = "";
            for(char c : num.toCharArray())
            {
                pre += c;
                mp.put(pre,mp.getOrDefault(pre,0)+1);
            }
        }
        int res = 0;
        for(int i : arr2)
        {
            String num = Integer.toString(i);
            String pre = "";
            for(char c : num.toCharArray())
            {
                pre += c;
                if(mp.containsKey(pre))
                res = Math.max(res,pre.length());
            }
        }
        return res;
    }
}