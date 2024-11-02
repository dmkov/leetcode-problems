"""
 abcde
 [0,3,4] -> " abc d e"

1. Each number in the list represents only 1 space?
2. Is spaces list sorted?
3. What is the possible length of the string?

iterate and construct a new string with the pointer to the spaces list
"""

class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        if not s or not spaces:
            raise Exception("Invalid arguments")
        res = ""
        p = 0
        for i, c in enumerate(s):
            if p < len(spaces) and spaces[p] == i:
                res += " "
                p += 1
            res += c
        return res
