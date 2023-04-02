package array.easy.maximum_subarray_53;

/**
 Given an integer array nums, find the subarray with the largest sum, and return its sum.

Q: Could there be negatives and zeros in the array?
Q: I only need the max sum, not indexes?
Q: Contiguous subarray?


[1,2,3,4,5] -> 15 ?
[1,-2,3,4,5] -> 12 ?
[-1,-2,-3,-4,-5] -> -1?

Solutions:
1. Naive: for all numbers check all possible subarrays with presum. O(n^2)
2. Iterative: for every element we can either continue subarray or start anew one
 */

public int getMaxSum(int[] arr) {
  if (arr == null || arr.length == 0) {
    throw new IllegalArgumentException();
}
int max = arr[0], curr = arr[0];
for (int i = 1; i < arr.length; i++) {
  curr = Math.max(curr + arr[i], arr[i]); // 12
  max = Math.max(max, curr);  // 12
}
return max;
}
