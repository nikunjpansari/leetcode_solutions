class Solution {
    public String getSmallestString(String s) {
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length-1; i++){
            if((ch[i]-'0')%2==(ch[i+1]-'0')%2 && ch[i]>ch[i+1]){
                char temp = ch[i];
                ch[i]=ch[i+1];
                ch[i+1]=temp;
                break;
            }
        }
        return new String(ch);
    }
}