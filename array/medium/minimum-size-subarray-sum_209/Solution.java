class Solution {
/**
    [1, 6, 0, 1, 1, 4], target = 7
     ____
        _______
        __________
        _____________
    
    we need to find the min number of elements
    


    Solutions:
    1. Naive approach: for each element iterate all sums
    O(n^2)

    2. Slide window: Since numbers are positive we can use slide window
    with two pointers. 1. Move the right pointer until reaching the target,
    then get (right-left) as a number of elements.
    Move left pointer and reduce the target, start again with the right element

    [2,3,1,2,4,3], target = 7
         l
             r
 */

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }

        int left = 0, sum = 0, min = Integer.MAX_VALUE; // 9, 4
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                found = true;
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }

        return found ? min : 0;
    }
}