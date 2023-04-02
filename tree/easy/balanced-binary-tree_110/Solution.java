/**

        1
       / \
      1   2
    /    /  \ 
   1    2    2
              \
                2 

   min = min(leftMin, rightMin)
   max = max(leftMax, rightMax)


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
    public boolean isBalanced(TreeNode root) {
        int[] res = getMinMaxHeight(root);
        return res[1] <= 1;
    }

    private int[] getMinMaxHeight(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = getMinMaxHeight(node.left);
        int[] right = getMinMaxHeight(node.right);
        int max = Math.max(left[0], right[0]) + 1;
        int diff = Math.max(Math.max(left[1], right[1]),
            Math.abs(left[0] - right[0]));
        return new int[]{max, diff};
    }
}

/**.  [4,2] -> false
  [1,1] 1 [3,2]
       / \
      1   2 [3,2]
         /  \ 
        2    2 [2,1]
              \
                2. [1,1] 

       [4,3] -> false
  [2,2] 1 [3,2]
       /  \
[2,2] 1    2 [3,2]
       \  /  \ 
       1 2    2 [2,1]
               \
                 2. [1,0] 

*/