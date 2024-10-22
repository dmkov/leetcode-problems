"""
Can we assume that we always have a valid ip address?
Does it mean that we have number and dots only? No characters?
There is no more than 3 digits between dots and digits are from 0 to 9?

Iterate over the string and create a new string with the copied chars,
if we meet ".", then replace it with "[.]"

O(n) - time, O(n) - space
"""

class Solution:
    def defangIPaddr(self, address: str) -> str:
        if not str or str == "":
            raise Exception("Illegal address argument")
        res = ""
        for ch in address:
            if ch == ".":
                res += "[.]"
            else:
                res += ch
        
        return res
