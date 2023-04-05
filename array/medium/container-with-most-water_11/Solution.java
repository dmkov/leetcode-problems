
/**
      |   |
  |   |   |
  |   |   |
  | | | | |
| | | | | |
0 1 2 3 4 5  -> 16
      l   r

Solutions:
1. Naive: for every line i with the combination of k, check (k - i) * Math.min(h[k], h[ki])
O(n^2)

2. Two pointers: start with left = 0 and right = end, compute the area. Then shift a smaller pointer and find the max area until left reachs right
O(n)
 */

class Solution {
    public int maxArea(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }       
        int max = 0; // 16
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int area = Math.min(arr[r], arr[l]) * (r - l);
            max = Math.max(area, max);
            if (arr[r] > arr[l]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
