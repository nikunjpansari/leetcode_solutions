// Time Complexity : O(rowIndex)
// Space Complexity : O(rowIndex)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        long ans = 1;
        row.add((int) ans); // Add 1st element to the row

        // Calculate the rest of the row
        for (int i = 1; i <= rowIndex; i++) {
            ans = ans * (rowIndex - i + 1) / i;
            row.add((int) ans);
        }

        return row;
    }
}