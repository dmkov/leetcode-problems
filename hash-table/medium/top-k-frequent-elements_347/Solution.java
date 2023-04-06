/**
    Q: If we do not have duplicates or there is same frequency for more elements?
    Q: It can be any interger number?

    [1,2,1,3,3,-1,-1,0,3]  k =3
    -> [3, 1, -1]
    
    [1,2,3,4]  k =3
    -> [1, 2, 3]
    
    Solution:
    1. Use heap to sort hash map entries by occurencies
    2. Quickselect by moving all required items after pivot

 */
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            throw new IllegalArgumentException();
        }
        
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] arr = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[i++] = entry.getKey();
        }

        /**
            [1,1,1,2,2,3]
            1: 3, 2:2, 3:1
            [1,2,3]
               l
               r
         */

        int left = 0, right = arr.length - 1;
        int pivot = -1;
        while (pivot != k - 1) {
            pivot = quickselect(arr, map, left, right);
            if (pivot > k - 1) {
                right = pivot - 1; // 1
            } else if (pivot < k - 1) {
                left = pivot + 1;
            }
        }

        return Arrays.copyOf(arr, k);
    }

    private int quickselect(int[] nums, Map<Integer, Integer> map, int left, int right) {
        int p = map.get(nums[right]);
        int j = left, i = left;
        while (i < right) {
            if (map.get(nums[i]) >= p) {
                // swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            } 
            i++;
        }
        int temp = nums[right];
        nums[right] = nums[j];
        nums[j] = temp;

        return j;
    }


    // public int[] topKFrequent(int[] nums, int k) {
    //     if (nums == null || nums.length < k) {
    //         throw new IllegalArgumentException();
    //     }
    //     Map<Integer, Integer> map = new HashMap();
    //     for (int num : nums) {
    //         map.put(num, map.getOrDefault(num, 0) + 1);
    //     }

    //     Queue<Integer> heap = new PriorityQueue<>(
    //         (n1, n2) -> map.get(n2) - map.get(n1));
    //     for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
    //         heap.add(entry.getKey());
    //     }

    //     int[] res = new int[k];
    //     while (k > 0) {
    //         res[k - 1] = heap.poll();
    //         k--;
    //     }
    //     return res;
    // }
}