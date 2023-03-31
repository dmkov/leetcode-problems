/**

    Q: Is there are only one target?
    Q: Array of integers and target is integer?

    -1,2,6,6    6
     
 */

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length; // 0 , 3
        while (left < right) {
            int mid = left + (right - left) / 2; // 1
            if (nums[mid] <= target) {
                left = mid + 1; // 3
            } else {
                right = mid; // 3
            }
        }
        return (left > 0 && nums[left - 1] == target) ? left - 1 : - 1;
    }
}