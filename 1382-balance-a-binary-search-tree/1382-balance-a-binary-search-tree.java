class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> v  = new ArrayList<Integer>();
        inorder(root,v);
        int n = v.size();

        return bst(v,0,n-1);
    }
    public void inorder(TreeNode root , ArrayList<Integer> v)
    {
    if(root == null)
    return;

    inorder(root.left,v);
    v.add(root.val);
    inorder(root.right,v);
    }
    public TreeNode bst( ArrayList<Integer> v, int s,int e){
        if(s>e)
        return null;

        int mid = (s+e)/2;
        TreeNode k = new TreeNode(v.get(mid));
        k.left = bst(v,s,mid-1);
        k.right = bst(v,mid+1,e);

        return k;
    }
}