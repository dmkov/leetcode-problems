/**

        5
       / \
      3   7
     / \   \
    1   4.  9


Naive: for every element, iterate over the tree and find the difference. Min is the answer
O(n^2)

Q: How we can use the fact of BST?
Q: Can we modify the tree? - yes
Q: Can we have negatives?

Inorder traverse + stack.
    O(n) + O(n)
Morris traverse.
    O(n) + O(1) but the input is modified

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

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        Integer val = null;
        int min = Integer.MAX_VALUE;
        while (root != null) {
            if (root.left != null) {
                TreeNode left = root.left;
                while (left.right != null) {
                    left = left.right;
                }

                left.right = root;
                TreeNode temp = root.left;
                root.left = null;
                root = temp;
            } else {
                if (val != null) {
                    min = Math.min(min, Math.abs(root.val - val));
                }
                val = root.val;
                root = root.right;
            }

        }

        return min;
    }

    // public int getMinimumDifference(TreeNode root) {
    //     if (root == null) {
    //         throw new IllegalArgumentException();
    //     }
    //     int min = Integer.MAX_VALUE;
    //     Integer val = null; //5

    //     Deque<TreeNode> stack = new ArrayDeque(); // 4, 2
    //     while (!stack.isEmpty() || root != null) {
    //         while (root != null) {
    //             stack.push(root);
    //             root = root.left;
    //         }
    //         root = stack.pop();
    //         if (val != null) {
    //             min = Math.min(min, Math.abs(root.val - val));
    //         }
    //         val = root.val;
    //         root = root.right;
    //     }

    //     return min;
    // }
}