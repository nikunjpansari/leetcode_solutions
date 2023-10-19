class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        int n = operations.length;
        int[] ls = new int[n];

        for(int i = 0,j=-1;i<n;i++)
        {
        if(operations[i].equals("C"))
        {
            ls[j] = 0;
            j--;
        }
        else if(operations[i].equals("D"))
        {
            j++;
            ls[j] = 2 * ls[j-1];
        }
        else if(operations[i].equals("+"))
        {
            j++;
            ls[j] = ls[j-1] + ls[j-2];
        }
        else
        {
        j++;
        ls[j] = Integer.parseInt(operations[i]);
        }
        }
        for(int i : ls)
        {
            res += i;
        }
        return res;
    }
}