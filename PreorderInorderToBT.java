/* 105. Construct Binary Tree from Preorder and Inorder Traversal */

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
class PreorderInorderToBT {
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     return build(0, preorder.length, 0, prerorder, inorder);
    // }
    Map<Integer, Integer> inMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        
        TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

        return root;
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, inRoot - 1);
        
        root.right = buildTree(preorder, inorder, preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd);
        
        return root;
    }
}
