/**

[1,2,3,4,5]
  2*3*4*5
1   3*4*5
1*2   4*5
1*2*3   5
1*2*3*4

Q: Should we care about integer overflow in the problem?
Q: Can I use additional space?

Solutions:
Presum: For every index in the array, compute presum and suffixsum, then iterate over array and multiple product before and after the active element.
O(n) + O(n)

 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        int l = nums.length;
        int[] presum = new int[l];
        int[] suffixsum = new int[l];
        int[] res = new int[l];
        int sum = 1;
        for (int i = 0; i < l; i++) {
            sum *= nums[i];
            presum[i] = sum;
        }
        sum = 1;
        for (int i = l - 1; i >= 0; i--) {
            sum *= nums[i];
            suffixsum[i] = sum;
        }
        for (int i = 0; i < l; i++) {
            int left = 1;
            if (i > 0) {
                left = presum[i - 1];
            }
            int right = 1;
            if (i < l - 1) {
                right = suffixsum[i + 1];
            }
            res[i] = left * right;
        }
        return res;
    }

}
