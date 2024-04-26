class Solution {
    public int minFallingPathSum(int[][] A) {
        for (int i = 1; i < A.length; i++) {
            int[] r = getSmallestTwo(A[i - 1]);
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] += (A[i - 1][j] == r[0]) ? r[1] : r[0];
            }
        }
        return getMin(A[A.length - 1]);
    }
    
    private int[] getSmallestTwo(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest) {
                secondSmallest = num;
            }
        }
        
        return new int[] {smallest, secondSmallest};
    }
    
    private int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
        }
        return min;
    }
}