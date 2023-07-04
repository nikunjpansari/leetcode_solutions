// Time Complexity : O(N)
// Space Complexity : O(1)
class Solution {
    public void nextPermutation(int[] A) 
    {
    int n = A.length; 
    if(A == null || n == 0)
    return;

    int i = n-2;
    while(i >= 0 && A[i]>=A[i+1]) i--;
    if(i >= 0)
    {
        int j =  n - 1;
        while(A[j] <= A[i]) j--;
        swap(A , i , j); 
    }
    reverse(A , i + 1 , n-1);
}

public void swap(int[] A, int i, int j) 
{
   int t = A[i];
   A[i] = A[j];
   A[j] = t;
}
public void reverse(int[] A, int i, int j) {
   while(i<j)
   swap(A,i++,j--);
}
}