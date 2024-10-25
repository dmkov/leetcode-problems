"""
 1,1,2,3,5,6,6
-> 5,6,6,1,1,2,3

1. Is given list always rotated?
2. Can it have any numbers, even negatives and zero?
3. Duplicates?

1. If left < right - the correct order, we can do a binary search
2. If left >= right - check recursively

"""
class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        if not nums or len(nums) == 0:
            return False
        return self.look(nums, target, 0, len(nums) - 1)

    def look(self, nums: List[int], target: int, s: int, e: int) -> bool:
        if s > e:
            return False
        if nums[s] < nums[e]:
            return self.binary_search(nums, target, s, e)
        
        m = round((e - s) / 2 + s)
        if nums[m] == target:
            return True
        
        return self.look(nums, target, s, m-1) or self.look(nums, target, m+1, e)

    def binary_search(self, nums: List[int], target: int, s: int, e: int) -> bool:
        if s > e:
            return False
        m = round((e - s) / 2 + s)
        if nums[m] == target:
            return True
        
        return self.binary_search(nums, target, s, m - 1) or self.binary_search(nums, target, m + 1, e)
        
