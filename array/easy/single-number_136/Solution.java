/**

[2,2,1,7,7] -> 1

Q: Can it be negatives? Or zeros in the array?
Q: Is it garanteed that we have a right answer?

Solutions:
Hash set: very simple but require additional space.
Sorting: not linear time complexity

2-2+1+7-7

2*2*1*7*7

sum = 19
product = 200

 */

class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int num : nums) {
            sum = sum ^ num;
        }
        return sum;
    }
}