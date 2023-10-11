class Solution {
    HashSet<String> set=new HashSet<>();
    public List<String> restoreIpAddresses(String s) 
    {
        ArrayList<String> arr = new ArrayList<>();
        solve(0,s,arr);
        return new ArrayList<String>(set);
    }
    void solve(int i,String s,ArrayList<String> arr)
    {
        if(arr.size()==4 && i==s.length())
        {
        set.add(String.join(".",arr));
        return;
        }
        for(int j=i+1;j<=Math.min(i+3,s.length());j++)
        {
            String str=s.substring(i,j);
            if(Integer.parseInt(str)<=255 && (str.equals("0") || str.charAt(0)!='0'))
            {
                arr.add(str);
                solve(j,s,arr);
                arr.remove(arr.size()-1);
            }
        }

    }
}