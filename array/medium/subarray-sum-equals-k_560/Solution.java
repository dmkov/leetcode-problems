/**

 [1,1,2,1,-1] -> k =2
  -> 3

  1->0

  1-

  ___
      __
      ______

  Negative numbers means that we can not use sliding window with two pointers

  Solutions:
  1. Naive: For each element check all contiguous subarrays and count searched sums
    O(n^2)
  2. Presum: If we store presum for every index in the hashtable, we can tell how many 
    occurancies of (presum - k) we had in the past. And it means that k has been
    occurred exactly such number times.
    1. Add 0 index with 1 occurance to the map, iterate over array. 
    2. For every number, get (presum - k) and check it in the map. 
    3. If result exists - add number of occurances to the result
    4. Increase current (presum) by 1 in the map.

    [1,2,3]
    3

    0:1

 */


class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }        
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int occur = map.getOrDefault(sum - k, 0);
            res += occur;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
