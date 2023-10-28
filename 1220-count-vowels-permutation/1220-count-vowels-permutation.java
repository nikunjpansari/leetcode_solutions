class Solution 
{
  private Map<String,Long> mp = new HashMap<>();
  private int mod = 1000000007;

  public int countVowelPermutation(int n) 
  {
    long total = 0;
    char[] charSet = new char[]{'a','e','i','o','u'};
    for(char c : charSet) 
    {
      total = (total + solve(n-1,c)) % mod;
    }
    return (int)total;
  }

  public long solve(int r, char p) 
  {
    if(r == 0) 
    return 1;

    String key = "" + r + p;

    if(mp.containsKey(key)) 
    return mp.get(key);

    long total = 0;

    switch(p) 
    {
      case 'a': 
      total = (solve(r - 1,'e')) % mod;
      break;
      
      case 'e': 
      total = (solve(r - 1,'a') + solve(r - 1, 'i')) % mod;
      break;

      case 'i': 
      total = (solve(r - 1,'a') + solve(r - 1, 'e') + solve(r - 1, 'o') + solve(r - 1, 'u')) % mod;
      break;

      case 'o': 
      total = (solve(r - 1,'i') + solve(r - 1,'u')) % mod;
      break;

      case 'u': total = (solve(r - 1,'a')) % mod;
      break;
    }
    mp.put(key , total);
    return total;
  }
}