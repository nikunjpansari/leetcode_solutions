class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) 
    {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        int indx1 = 0 ;
        int indx2 = 0;
        for(int i = 0 ; i < res.size(); i++)
        {
            if(res.get(i) == low)
            indx1 = i;

            if(res.get(i) == high)
            indx2 = i;
        }
        int sum = 0;
        for(int i = indx1;i<=indx2;i++)
        {
            sum +=res.get(i);
        }
        return sum;
    }
    public void inorder(TreeNode root , List<Integer> res)
    {
        if(root == null)
        return;

        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}