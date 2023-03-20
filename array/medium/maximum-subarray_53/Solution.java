package array.easy.maximum_subarray_53;

/**
 53. Maximum Subarray
 https://leetcode.com/problems/maximum-subarray/

 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 
 Example:
 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6

 Explanation: [4,-1,2,1] has the largest sum = 6.

 Input: [-3],
 Output: -3
  
 Input: []
 Output: 0

 Solutions:
  1. For every element iterate to the end of the array, add the next number and find the max
  O(n) -> n^2
  2. For every i:
    sum[i] - max sum ending that number
    subarray[i] - max sum between 0 and i

 Q:
  - Should it be a continious subarray?
 */

class Solution {
    public int maxSubArray(int[] nums) {
        
    }
}