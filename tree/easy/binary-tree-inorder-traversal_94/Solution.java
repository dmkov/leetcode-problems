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

Q: Inorder means: left, root and then right?
Q: What is the output format? 

        1
       / \
      3.  6
     / \ 
    4   5 

-> [4, 3, 5, 1, 6] ?

O(n) , O(n + logh) 

 */
class Solution {
    
    // Morris Traversal:
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        
        while (root != null) {
            if (root.left != null) {
                TreeNode newRoot = root.left;
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = root;
                root.left = null;
                root = newRoot;
            } else {
                list.add(root.val);
                root = root.right;
            }
        }

        return list;
    }

    // Stack:
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList();
    //     Deque<TreeNode> stack = new ArrayDeque();
    //     TreeNode curr = root;
    //     while (stack.size() > 0 || curr != null) {
    //         while (curr != null) {
    //             stack.push(curr);
    //             curr = curr.left;
    //         }
    //         curr = stack.pop();
    //         list.add(curr.val);
    //         curr = curr.right;
    //     } 

    //     return list;
    // }

    // Recursive:
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList();
    //     inorderTraversal(root, list);
    //     return list;
    // }

    // public void inorderTraversal(TreeNode root, List<Integer> list) {
    //     if (root == null) {
    //         return;
    //     }
    //     inorderTraversal(root.left, list);
    //     list.add(root.val);
    //     inorderTraversal(root.right, list);
    // }
}