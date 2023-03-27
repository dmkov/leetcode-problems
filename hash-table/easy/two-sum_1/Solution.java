class Solution {

/**

[1,2,3,5] k = 3 -> [0,1]

Q: could it be that array does not have an answer?
Q: does order of indexes in the response matter?
Q: negative numbers are also allowed?

Solutions:
1. Naive - iterate over the array and check every possible pairs
2. Hash map - check, if required number is in the map, if not - store the current number
    with its index. Otherwise, return both stored and active indexes. O(n) + O(n)

 */

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException();
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer num = map.get(target - nums[i]);
            if (num != null) {
                result = new int[]{num, i};
            }
            map.put(nums[i], i);
        }
        return result;
    }
}