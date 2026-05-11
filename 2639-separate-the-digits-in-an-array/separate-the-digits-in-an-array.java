class Solution {
    public int[] separateDigits(int[] nums) {
        int[] ans = new int[0];
        String s = "";
        for (int k : nums) {
            s = String.valueOf(k);
            for (int i = 0; i < s.length(); i++) {
                ans = Arrays.copyOf(ans, ans.length + 1);
                ans[ans.length - 1] = s.charAt(i) - '0';
            }
        }
        return ans;
    }
}