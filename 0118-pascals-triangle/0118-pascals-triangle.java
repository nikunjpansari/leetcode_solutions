// Time Complexity : O(n^2)
// Space Complexity : O(1)
class Solution {
    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // Inserting the 1st element

        // Calculate the rest of the elements
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        // Store the entire Pascal's Triangle
        for (int row = 1; row <= numRows; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }
}