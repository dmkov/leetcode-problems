/**

Q: Can we have duplicates in the array?
Q: Can it be negatives or zeros?

[-1,0,1,2,-1,-4]
-> [-1,0,1], [2,-1,-1]

[-4,-1,-1,0,1,2]

Naive: for each element check two other other numbers and compute the sum
O(n^3)

Hashmap: for the pair of two numbers, check if the 3 is presented in the map. use set with indexes to exclude duplicates from checking
O(n^2)

 */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet();
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }

        Set<Integer> dups = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = map.getOrDefault(nums[i], new HashSet());
            set.add(i);
            map.put(nums[i], set);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int sum = 0 - nums[i] - nums[j];
                    Set<Integer> set = map.get(sum);
                    if (set != null) {
                        for (int index : set) {
                            if (index != i && index != j) {
                                List<Integer> list 
                                    = new ArrayList(Arrays.asList(nums[i], nums[j], nums[index]));
                                Collections.sort(list);
                                res.add(list);
                                break;
                            }
                        }
                    }
                }
            }
        }

        return new ArrayList(res);
    }

    // public List<List<Integer>> threeSum(int[] nums) {
    //     List<List<Integer>> res = new ArrayList();
    //     if (nums == null || nums.length < 3) {
    //         throw new IllegalArgumentException();
    //     }

    //     Arrays.sort(nums);
    //     for (int i = 0; i < nums.length - 2; i++) {
    //         if (nums[i] > 0) {
    //             break;
    //         }
    //         if (i > 0 && nums[i] == nums[i - 1]) {
    //             continue;
    //         }

    //         Set<Integer> seen = new HashSet();
    //         for (int j = i + 1; j < nums.length; j++) {
    //             int sum = 0 - nums[i] - nums[j];
    //             if (seen.contains(sum)) {
    //                 res.add(Arrays.asList(nums[i], sum, nums[j]));
    //                 while (j+1 < nums.length && nums[j] == nums[j+1]) {
    //                     j++;
    //                 }
    //             }
    //             seen.add(nums[j]);
    //         }
    //     }
    //     return res;
    // }


    // public List<List<Integer>> threeSum(int[] nums) {
    //     List<List<Integer>> res = new ArrayList();
    //     if (nums == null || nums.length < 3) {
    //         throw new IllegalArgumentException();
    //     }

    //     Arrays.sort(nums);
    //     for (int i = 0; i < nums.length - 2; i++) {
    //         if (nums[i] > 0) {
    //             break;
    //         }
    //         if (i > 0 && nums[i] == nums[i - 1]) {
    //             continue;
    //         }
    //         int left = i + 1;
    //         int right = nums.length - 1;
    //         while (left < right) {
    //             int sum = nums[i] + nums[left] + nums[right];
    //             if (sum == 0) {
    //                 res.add(Arrays.asList(nums[i], nums[left], nums[right]));
    //                 left++;
    //                 while (left < right && nums[left - 1] == nums[left]) {
    //                     left++;
    //                 }
    //             } else if (sum > 0) {
    //                 right--;
    //             } else {
    //                 left++;
    //             }
    //         }
    //     }
    //     return res;
    // }
}