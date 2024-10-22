/**

        1
       / \ 
      3   2
     / \.  \
    4.  5    6
   /.  /
  7   8

        1
       / \ 
      2   3
     /   / \
    6    5  4
         \   \
          8   7

    Solution:
        Recursive: For every node, change left and right submodes recursively
        Iterative: Until stack is empty, pop item, reverse it and put children back to the stack.
            Can be done with Queue for the horizontal traverse.

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque();
        stack.push(root);
        while(stack.size() > 0) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    // public TreeNode invertTree(TreeNode root) {
    //     if (root == null) {
    //         return null;
    //     }
    //     TreeNode temp = root.left;
    //     root.left = root.right;
    //     root.right = temp;

    //     invertTree(root.left);
    //     invertTree(root.right);
    //     return root;
    // }
}