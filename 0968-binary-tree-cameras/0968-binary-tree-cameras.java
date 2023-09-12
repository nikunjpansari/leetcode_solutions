/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
      private int COVERED = 0, PLEASE_COVER = 1, HAS_CAMERA = 2;

        private int camera = 0;

        public int minCameraCover(TreeNode root) {
            return postorder(root) == PLEASE_COVER ? ++camera : camera;
        }

        private int postorder(TreeNode root) 
        {
            if (root == null)
                return COVERED;

            int left = postorder(root.left);
            int right = postorder(root.right);

            if (left == PLEASE_COVER || right == PLEASE_COVER) 
            {
                camera++;
                return HAS_CAMERA;
            } 
            else if (left == HAS_CAMERA || right == HAS_CAMERA) 
                return COVERED;
            else 
                return PLEASE_COVER;
            
        }
    }