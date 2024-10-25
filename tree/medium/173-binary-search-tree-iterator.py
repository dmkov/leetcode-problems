# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
     5
    / \
   2   4
     \
       1
[2,1,5,4]

"""
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = deque()
        while root is not None:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        if not self.hasNext():
            raise Exception("There is no next element")

        res = self.stack.pop()
        root = res.right
        while root is not None:
            self.stack.append(root)
            root = root.left

        return res.val


    def hasNext(self) -> bool:
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
