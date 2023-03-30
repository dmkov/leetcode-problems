/**

 | | | |
 1 1 1 1
 1.  2 1
   2 1 1
   2   2
 1.1.  2

 | | | | |
 1 1 1 1 1
   2 1 1 1
 1   2 1 1
 1.1.  2 1
   2   2 1
 1 1 1   2
 1.  2   2
   2 1   2

 1 - 1
 2 - 2
 3 - 3
 4 - 5
 5 - 8

 Q: We need to define ways to get exactly to the last step?
 

|
| |
| | | 
| | | |

Solution:
DP: To every step we can come either from the previous stair or from one before the previous.
In this case the sum of options will be n[i] = n[i-1] + n[i-2]. Iterate over array and populate values.

 */

class Solution {
    public int climbStairs(int n) { // 5
        if (n <= 0) {
            return 0;
        }
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        // 2: 2
        // 3: 3
        // 4: 5
        // 5: 8

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
}