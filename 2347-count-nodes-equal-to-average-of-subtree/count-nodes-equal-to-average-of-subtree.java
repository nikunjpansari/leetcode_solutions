class Solution {
    private static int res;
    public int averageOfSubtree(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    public static void helper(TreeNode root)
    {
    if(root == null)
    return;

    int sum = getSum(root.left) + getSum(root.right) + root.val;
    int n = numberOfNodes(root.left) + numberOfNodes(root.right) + 1;

    if(n!=0 && (root.val == (sum/n)))
    res += 1;

    helper(root.left);
    helper(root.right);
    }
    public static int getSum(TreeNode root)
    {
       if(root == null)
        return 0;

    return getSum(root.left) + getSum(root.right) + root.val;
    }
    public static int numberOfNodes(TreeNode root)
    {
       if(root == null)
        return 0;

    return numberOfNodes(root.left) + numberOfNodes(root.right) + 1;
    }
}