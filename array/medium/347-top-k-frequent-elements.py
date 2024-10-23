"""
1. Is the given array sorted?
2. Are they integer numbers?
3. K should be equal to the number of unique intergers? Otherwise -> max.

[1,2,1] , 2 -> [2,1]
[1,1,1] , 1 -> [1]

Approach
1) sorting nlogn
2) heap logn + n 

"""
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if not nums or k > len(nums):
            raise Exception("Wrong arguments")
        count = Counter(nums)
        res = heapq.nlargest(k, count.keys(), key=lambda m: count.get(m))
        return res

