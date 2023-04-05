/**

    prime number - number is greater than 1, that can be divided only by 1 or itself

    X mod 1 = 0
    X mod X = 0
    X mod 1..X != 0

    Solutions:
    1. Naive. For given n check all 1..n to ensure that n mod 1..n != 0
    O(n^2)

    10 -> 2,3,4,5,6,7,8,9
          | | X | X | X X

    2. Bottom-up. Precompute all products for numbers from 2 to sqrt(n) and mark them as not
    possible candidates in the range 2..n since they have a denominator with mod = 0. Iterate
    over the array then and check all not marked numbers.
    O(n) + O(n)

    2,3,4,5,6,7,8,9
        X       X X 

 */


class Solution {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] arr = new int[n];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int sum = i+i;
            while (sum < n) {
                arr[sum] = -1;
                sum += i;
            }
        }
        int res = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) {
                res++;
            }
        }
        return res;
    }
}