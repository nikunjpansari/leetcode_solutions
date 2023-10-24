class Solution {
    public List<Integer> largestValues(TreeNode root) 
    {
        List<Integer> res =new LinkedList<>();

        if(root==null) 
        return res;

        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) 
            {
                TreeNode node= q.poll();

                if(node.left!=null) 
                q.add(node.left);

                if(node.right!=null) 
                q.add(node.right);

                max= Math.max(max, node.val);
            }
            res.add(max);
        }
        return res;
    } 
}