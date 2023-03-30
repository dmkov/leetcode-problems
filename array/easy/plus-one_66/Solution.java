/**

Q: We have only digits from 0 to 9, right?
Q: Can we modify array or should create a new one?

Solution:
Set n = 1. Iterate from right to left and add n to each number.
If result is 10, set number to 0 and n=1, otherwise n=0.
At the end, if n is 1, copy array with shift to right.

 1 2 4 7
 
 m = 1
 0 0 0 0

 */

class Solution {
    public int[] plusOne(int[] digits) {
        int n = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += n;
            if (digits[i] == 10) {
                digits[i] = 0;
                n = 1;
            } else {
                n = 0;
                break;
            }
        }
        if (n == 1) {
            int[] d = new int[digits.length + 1];
            d[0] = 1;
            for (int i = 1; i <= digits.length; i++) {
                d[i] = digits[i - 1];
            }
            digits = d;
        }
        return digits;
    }
}