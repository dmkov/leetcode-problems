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
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> map.get(n2) - map.get(n1));
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            heap.add(entry.getKey());
        }

        int[] res = new int[k];
        while (k > 0) {
            res[k - 1] = heap.poll();
            k--;
        }
        return res;
    }
}