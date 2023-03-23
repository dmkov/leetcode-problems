/**

 [1,2,3,4], 2
    ^ 
  -> 1

 [1,4], 2
    ^ 
  -> 1

 [1,4], 5
      ^ 
  -> 2

  In other words, find the biggest smaller element and return i+1 index

  Q: We are given integer array?
  Q: All elements are sorted from smaller to bigger?


  Solutions:
  1. Naive, iterate the array - O(n)
  2. Binary search - O(logn)
*/


class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }

        int left = 0, right = nums.length - 1, // 2,3
            mid = 0;
        while (left <= right) {
            mid = left + (right - left)/2; //2
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
                mid = mid + 1;
            } else {
                break;
            }
        }

        return mid;
    }
}