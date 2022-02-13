/* https://leetcode.com/problems/binary-tree-right-side-view */

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
class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return Collections.emptyList();
    final List<Integer> rightMostNodes = new ArrayList<>();
    rightView(root, rightMostNodes, 0);
    return rightMostNodes;
  }
  
  public void rightView(TreeNode node, List<Integer> rightMostNodes, int level) {
    if (node == null) return;
    
    if (rightMostNodes.size() == level) {
      rightMostNodes.add(node.val);
    }
    
    rightView(node.right, rightMostNodes, level + 1);
    rightView(node.left, rightMostNodes, level + 1);
    
  }
}
