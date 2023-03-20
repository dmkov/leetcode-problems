/**
Examples:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.

Q: There can be duplicates? Arrays are not sorted?

Q: Can we update the original array?
- yes

Q: What is the response format should be?
- array

Q: If there is no intersections - empty array?
- yes

[1,2,3] and [4,5] -> []
[1,1] and [1,2,3] -> [1]
[1,1] and [1,1] -> [1,1]

Solutions:
1. Use a hashmap for the smaller array with key->num, and value->occurence
Iterate through the second array, all matches -> decrement in the hashmap and store in the result
O(n) + O(n) for the space

2. Sort both arrays and use two pointers
O(nlogn) + O(1) for space
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        List<Integer> result = new LinkedList();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i]) == 1) {
                    map.remove(nums2[i]);
                } else {
                    map.replace(nums2[i], map.get(nums2[i]) - 1);
                }
                result.add(nums2[i]);
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    // Sorting: 
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     if (nums1 == null || nums2 == null || nums1.length == 0 || nums1.length == 0) {
    //         return new int[0];
    //     }

    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);

    //     List<Integer> result = new LinkedList();
    //     int i = 0, k = 0;
    //     while (i < nums1.length && k < nums2.length) {
    //         if (nums1[i] == nums2[k]) {
    //             result.add(nums1[i]);
    //             i++;
    //             k++;
    //         } else if (nums1[i] > nums2[k]) {
    //             k++;
    //         } else {
    //             i++;
    //         }
    //     }

    //     int[] res = new int[result.size()];
    //     for (int j = 0; j < result.size(); j++) {
    //         res[j] = result.get(j);
    //     }
    //     return res;
    // }
}