class Solution {
    List<String> ls = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve(ls,0,0,n,"");
        return ls;
    }
    public void solve(List<String> ls,int s,int e,int n, String str)  { 
        if(str.length() == (2*n))
        {
            ls.add(str);
            return;
        }
        if(s < n)
        solve(ls,s+1,e,n,str + '(');

        if(e < s)
        solve(ls,s,e+1,n,str + ')');
    }
}