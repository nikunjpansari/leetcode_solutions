class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0,s,path,res);
        return res;
    }
    void func(int index,String s,List<String> path,List<List<String>> res)
    {
        if(index == s.length())
        {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index;i<s.length();++i)
        {
            if(isPalindrome(s,index,i))
            {
            path.add(s.substring(index,i+1));
            func(i+1,s,path,res);
            path.remove(path.size()-1);
            }
        }
    }
    boolean isPalindrome(String s, int st ,int e)
    {
        while(st<=e)
        {
        if(s.charAt(st++) != s.charAt(e--))
        return false;
        }
        return true;
    }
}