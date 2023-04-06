/**

n = 5
[1,2,0,5,4] (missing 3)
[-1,-2,-0,5,-4] (missing 3) flag

[6,2,0,5,4,1] (missing 3) 
[6,2,0,5,4,1] flag

if flag -> look for negative or zero
if !flag -> it is the answer


Q: All numbers are positive and there are no duplicates?
Q: Can we modify the input array?

Solutions:
1. Set. Put all numbers there and then iterate from 0..n to check O(n) + O(n)
2. Indexes in the array: For every number invert element with the index num (for 0 just put -1) and then find positive number so the answer would be i. For the last N use additional flag.
3. Math: get required sum of all items, and then substract actual sum. The result will be the answer.

 */

class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int required = 0;
        int fact = 0;
        for (int i = 1; i <= nums.length; i++) {
            required += i;
            fact += nums[i - 1];
        }

        return required - fact;
    }

    // public int missingNumber(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         throw new IllegalArgumentException();
    //     }
    //     boolean last = false;
    //     for (int i = 0; i < nums.length; i++) {
    //         int indx = Math.abs(nums[i]); 
    //         if (indx == nums.length) {
    //             last = true;
    //         } else {
    //             nums[indx] = -nums[indx];
    //         }
    //     }
    //     if (!last) {
    //         return nums.length;
    //     }
    //     int res = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == 0) {
    //             res = i;
    //         } else if (nums[i] > 0) {
    //             res = i;
    //             break;
    //         }
    //     }
    //     return res;
    // }
}


