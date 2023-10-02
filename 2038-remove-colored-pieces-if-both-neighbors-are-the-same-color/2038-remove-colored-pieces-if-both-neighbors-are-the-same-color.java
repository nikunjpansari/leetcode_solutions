class Solution {
    public boolean winnerOfGame(String colors) {
    int n = colors.length();
    int a = 0, b = 0;
    for (int i = 0; i < n; i++) {
        char ch = colors.charAt(i);
        int j = i + 1;
        while (j < n && colors.charAt(j) == ch)
            j++;

        j--;

        if (ch == 'A')
            a += Math.max(0, j - i + 1 - 2);
        else
            b += Math.max(0, j - i + 1 - 2);
        i = j;
    }
    return a > b;
}

}