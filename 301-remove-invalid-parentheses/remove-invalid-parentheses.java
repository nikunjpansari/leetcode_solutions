class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        int open = 0;
        int close = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        solve(s, 0, open, close, 0, "", ans);
        return ans;
    }
    void solve(String s, int index, int openRemove, int closeRemove,
               int balance, String current, List<String> ans) {
        if (index == s.length()) {
            if (openRemove == 0 && closeRemove == 0 && balance == 0) {
                if (!ans.contains(current)) {
                    ans.add(current);
                }
            }
            return;
        }
        char ch = s.charAt(index);
        if (ch == '(' && openRemove > 0) {
            solve(s, index + 1, openRemove - 1, closeRemove,
                  balance, current, ans);
        }
        if (ch == ')' && closeRemove > 0) {
            solve(s, index + 1, openRemove, closeRemove - 1,
                  balance, current, ans);
        }
        if (ch != '(' && ch != ')') {
            solve(s, index + 1, openRemove, closeRemove,
                  balance, current + ch, ans);
        } 
        else if (ch == '(') {
            solve(s, index + 1, openRemove, closeRemove,
                  balance + 1, current + ch, ans);
        } 
        else if (balance > 0) {
            solve(s, index + 1, openRemove, closeRemove,
                  balance - 1, current + ch, ans);
        }
    }
}