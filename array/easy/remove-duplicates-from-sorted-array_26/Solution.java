/**
26. Remove Duplicates from Sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.


Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Input: nums = [0,0,0]
Output: 1, nums = [0,0,0]

Input: nums = [0,0,0,1,1,1,2]
Output: 3, nums = [0,1,2,1,1,1,2]

Input: nums = [0]
Output: 1, nums = [0]

Input: nums = []
Output: 0, nums = [] ?

Solutions:
1. Iterate array using two pointers: i and k. 
    - if a[i] == a[i-1] -> i++
    - if a[i] != a[i-1] -> copy a[i] to a[k], i++, k++
O(n)

[0,1,2,1,1,1,2]
             i
       k
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid nums argument");
        }
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}