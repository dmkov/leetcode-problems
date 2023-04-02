/**

Q: We have integer number, right? 

[3,100,0,4,2,-1,1,99]


3: [1,2]
100:[1,1]
0:[2,1]
4:[6,1]
2:[1,3]
-1:[1,6]
1:[3,4]

Solutions:
    for every element: 
    1. check if element - 1 is in the map
        if yes: min = num - 1[0] + 1
        if no: min = 1
    2. check if element + 1 is in the map
        if yes: max = num+1[1] + 1
        if no: max = 1
    3. add num[min, max] to the map

    compute length = min+max-1 // 3
    4. if min != 1
        num-min+1[1] = min + max - 1
    5. if max != 1
        num+max-1[0] = min + max - 1

simplified:
    Add all numbers to the set. Iterate over set, for every element check if num-1 exists.
    If yes - skip iteration, if not (beginning of strike) - iterate until end and get the max.

 */

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            int strike = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + 1)) {
                    strike++;
                    num++;
                }
            }
            max = Math.max(strike, max);
        }
        return max;
    }



    // public int longestConsecutive(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     Map<Integer, List<Integer>> map = new HashMap();
    //     int lenMax = 0;
    //     for (int num : nums) {
    //         if (map.get(num) != null) {
    //             continue;
    //         }
    //         int min = (int)(map.getOrDefault(num - 1, 
    //             new ArrayList(Arrays.asList(0, 0))).get(0)) + 1;
    //         int max = (int)(map.getOrDefault(num + 1, 
    //             new ArrayList(Arrays.asList(0, 0))).get(1)) + 1;
    //         map.put(num, new ArrayList(Arrays.asList(min, max)));
            
    //         int len = min + max -1;
    //         lenMax = Math.max(lenMax, len);
    //         if (min != 1) {
    //             List<Integer> arr = map.get(num - min + 1);
    //             arr.set(1, len);
    //             map.put(num - min + 1, arr);
    //         }
    //         if (max != 1) {
    //             List<Integer> arr = map.get(num + max - 1);
    //             arr.set(0, len);
    //             map.put(num + max - 1, arr);
    //         }
    //     }
    //     return lenMax;
    // }
}