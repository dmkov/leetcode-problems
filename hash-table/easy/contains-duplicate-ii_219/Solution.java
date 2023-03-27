class Solution {

/**

    [1,2,3,1] k = 3 -> true
    [1,2,1] k = 3 -> false
    [1,2,1,1] k = 3 -> true
    [1] k = 3 -> false

    Q: We are given integers?

    Solutions:
    1. Naive: For every number check the rest of the array
    Can be optimized to check only forward and within k, but still O(n^2)

    2. Hashmap: Store index of the evelement as a value with the number as a key
    If number already exists, then check k and either update hashmap or return true.
 */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length + 1 < k) {
            return false;
        }
        boolean result = false;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer prev = map.get(nums[i]);
            if (prev != null && i - prev <= k) {
                result = true;
                break;
            }
            map.put(nums[i], i);
        } 
        return result;
    }
}