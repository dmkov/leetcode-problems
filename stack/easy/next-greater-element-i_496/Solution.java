/**

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]


Q: both arrays are unordered? yes
Q: all elements from the 1st arrays are presented in 2nd? yes
Q: So the possible output for every index either -1 or another int from nums2? yes
Q: both arrays have integer values? yes
Q: can the 1st array be empty? no
Q: no duplicates in the arrays? no

nums1 = [2,4], nums2 = [1,2,3,4]


[4,5,2,3,1]

Solutions:
1. Bruteforce - O(n*m). Can be optimised with HashMap with number:index
2. Stack 

   |
   |. |
   |. |.    |
   |. |. |. |
   |. |. |  |  |

   If decrease -> peek the first item, add the current one
   If increase -> peek the first item, if smaller then pop, add the current one

 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums2.length < nums1.length) {
            throw new IllegalArgumentException();
        }

        Deque<Integer> stack = new ArrayDeque();
        Map<Integer, Integer> map = new HashMap();

        for (int i = nums2.length - 1; i >= 0; i--) { //3
            int num = nums2[i], res = -1; 
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res = stack.peek();
            }
            stack.push(num);
            map.put(num, res);
        }
        // 1: -1, 3: 4, 2: 3, 4: -1, 5: -1
        // stack : 
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}