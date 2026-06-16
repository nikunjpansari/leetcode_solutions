class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0 ; i < n ; i++)
        {
            char ch = s.charAt(i);
            if(Character.isLetter(ch))
            sb.append(ch);
            if(ch == '#')
            sb.append(sb);
            if(ch == '%')
            sb.reverse();
            if(ch == '*')
            {
                if(sb.length() > 0)
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}