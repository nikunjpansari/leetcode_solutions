//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    
   public Node buildTree(int[] in, int[] post, int n) {
    Map<Integer, Integer> mp = new HashMap<>();
    for (int i = 0; i < n; i++) {
        mp.put(in[i], i);
    }
    return solve(in, 0, n - 1, post, 0, n - 1, mp);
}

public Node solve(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> mp) {
    if (inStart > inEnd || postStart > postEnd)
        return null;

    Node root = new Node(postorder[postEnd]);

    int inRoot = mp.get(root.data);
    int numsRight = inEnd - inRoot;

    root.right = solve(inorder, inRoot + 1, inEnd, postorder, postEnd - numsRight, postEnd - 1, mp);
    root.left = solve(inorder, inStart, inRoot - 1, postorder, postStart, postEnd - numsRight - 1, mp);

    return root;
}
}
