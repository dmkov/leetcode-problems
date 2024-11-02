"""
1. What is the possible range of numbers?
2. Are negatives allowed?
3. How many numbers are in the list?
4. What if multiple numbers have the same number of 1s? Should we sort them?
5. Can we mutate the original list?

[0,2,3,1,6] -> [0, 1, 2, 3, 6]

0 - 0
1 - 1
2 - 1
3 - 2
4 - 1
5 - 2

Create a hash for all numbers with number of 1s
Sort function to sort the list using the hash
    -> if hash is equal then compare values
"""

class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        if not arr or len(arr) < 1:
            raise Exception("Invalid arguments")
        hashmap = {}
        for num in arr:
            hashmap[num] = self.calculateNumbers(num)
        arr.sort(key=lambda num: (hashmap[num], num))
        return arr
    
    def calculateNumbers(self, num: int) -> int:
        counter = 0
        while num:
            counter += num & 1
            num = num >> 1
        return counter
