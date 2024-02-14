class Solution {
   public int[] sortArrayByParityII(int[] A) {
    for (int i = 0, j = 1; j < A.length && i < A.length;) {
        if (A[i] % 2 == 0) {
            i += 2;
        } else if (A[j] % 2 == 1) {
            j += 2;
        } else {
            
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            
            i += 2;
            j += 2;
        }
    }
    return A;
}

}