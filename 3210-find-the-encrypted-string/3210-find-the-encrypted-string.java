class Solution {
    public String getEncryptedString(String s, int k) {
        int size = s.length();
        k %= size;
        s = s + s;
        return s.substring(k, k + size);
    }
}