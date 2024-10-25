# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
     4
    / \ 
   2   3
    \
      1
1. Are there any duplicates in the tree?
2. Both arrays contain the same list of numbers?

preorder [4,2,1,3]
inorder [2,1,4,3]

"""
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder or len(inorder) == 0:
            return None
        
        pos = inorder.index(preorder[0])
        node = TreeNode(preorder.pop(0))
        node.left = self.buildTree(preorder, inorder[:pos])
        node.right = self.buildTree(preorder, inorder[pos+1:])
        return node
