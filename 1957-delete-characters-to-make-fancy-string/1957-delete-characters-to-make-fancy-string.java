class Solution {
        public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, cnt = 0; i < s.length(); ++i) {
            if (i > 0 && s.charAt(i - 1) == s.charAt(i))
                ++cnt;
            else 
                cnt = 1;
            if (cnt < 3) 
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}