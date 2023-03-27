/**

[0,1,1,1,0,0,0,0]  -  2 -> true
[0,1,1,1,0,0,0]  -  2 -> false


[1,0,1]  ([0]) -> 1 spot
[0,0] -> 1 spot
[0,0,0] -> 2 spots
[1, 0, 0, 1] -> ? 1
[1, 0, 0, 0, 1] -> 1
[0, 0, 0, 1] 
when 1 - flag -> true 
when 0 and flag -> false
when 0 and !flag -> +1 we update flag to true

[1, 0, 0, 0, 1]
O(n) 

 */

class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        if (arr == null || arr.length < n) {
            throw new IllegalArgumentException();
        }
        boolean available = true;
        int num = 0; // 1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                available = false;
            } else if (available) {
                if (i == arr.length - 1 || arr[i + 1] == 0) {
                    num++;
                    if (num == n) {
                        break;
                    }
                } 
                available = false;
            } else {
                available = true;
            }
        } 
        return num >= n;

    }
}