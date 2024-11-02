"""
1. Can I modify the list?
2. What is the possible range of values? Always 0 or greater?
3. Can the list be empty?

[1,2,3,0] -> True
[3,2,1,0] -> False 

1: invert the sign of the number
iterate over the list, if zero of negative - return False
2: iterate over array, take the max, see if you can get to the end
"""

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums or len(nums) == 0:
            raise Exception("Invalid argument")

        val = 0
        for i, num in enumerate(nums):
            if val < 0:
                return False
            if num > val:
                val = num
            val -= 1
        return True
