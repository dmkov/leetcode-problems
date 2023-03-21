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

/**
Q: Are we given binary trees?
Q: What are values of the nodes - int?
Q: Do we know what specific tree we need to check as a subtree?
Q: Can it be more than 1 matches?

       1
      / \
     2   3
    /
   3 

     2 
    /    -> true
   3 

     5
    /    -> false
   3 

     2
    /    -> false
   3
    \
     5
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isEqual(root, subRoot)) {
            return true;
        } else if (root != null) {
            return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
        }
        return false;
    }

    public boolean isEqual(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return a == b;
        }
        return a.val == b.val
            && isEqual(a.left, b.left)
            && isEqual(a.right, b.right);
    }
}