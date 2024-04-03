class Solution {
    public boolean exist(char[][] b, String word) 
    {
        for(int r=0; r<b.length; r++)
            for(int c=0; c<b[0].length; c++)
                if(b[r][c]==word.charAt(0) && help(b,word,0,r,c))
                    return true;
        
        return false;
    }
    
    public boolean help(char[][] b, String word, int start, int r, int c)
    {
        if(word.length() <= start)
            return true;
        
        if(r<0 ||c<0 || r>=b.length || c>=b[0].length || b[r][c]=='0' || b[r][c]!=word.charAt(start))
            return false;
        
        char tmp = b[r][c];
        b[r][c] = '0';
        
        if(help(b,word,start+1,r+1,c) ||
          help(b,word,start+1,r-1,c) ||
          help(b,word,start+1,r,c+1) ||
          help(b,word,start+1,r,c-1))
            return true;
        
        b[r][c] = tmp;
        
        return false;
    }
}