/* https://leetcode.com/problems/binary-tree-level-order-traversal */

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
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
    final List<List<Integer>> levelOrderList = new ArrayList<>();
    
    if (root == null) return levelOrderList;
    
    final Queue<TreeNode> elementsQueue = new ArrayDeque<>();
    elementsQueue.add(root);

    while (!elementsQueue.isEmpty()) {
      final List<Integer> currentLevel = new ArrayList<>();
      int size = elementsQueue.size();
      for (int i = 0; i < size; i++) {
        TreeNode currentNode = elementsQueue.remove();
        currentLevel.add(currentNode.val);

        if (currentNode.left != null) {
          elementsQueue.add(currentNode.left);

        }
        if (currentNode.right != null) {
          elementsQueue.add(currentNode.right);
        }
      }
      levelOrderList.add(currentLevel);
    }
    return levelOrderList;
    }
}
