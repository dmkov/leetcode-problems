/**

        3.  -> 4
       / \
      1.  2
     /.    \
    1        3
              \
               4

        1.  -> 1

        []  -> 0

    Solutions:
     1. Recursive: for every element, if it is null -> return 0, otherwise,
        call the same method for childred, find max and add +1
        O(n) + O(n)

    2. Iterative: Using queue do horizontal traverse
        O(n) + O(n)

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
    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (queue.size() > 0) {
            Deque<TreeNode> level = queue;
            queue = new LinkedList();
            while (level.size() > 0) {
                TreeNode node = level.removeFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res++;
        }
        return res;
    }

    // public int maxDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    // }
}