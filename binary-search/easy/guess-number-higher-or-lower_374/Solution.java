/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

/**

0 .. n
API guess(y) -> 1 (higher), -1 (lower), 0 - win!

Q: is it always integers? no overflows?

Solutions:
1. Binary search. 
Pick the number in the middle. If the result is smaller -> go left,
otherwise -> go right. If 0 -> return the number

1 2 3 4 5
l       r

 */ 
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int left = 1, right = n, num = 0, res = -1;
        while (res != 0) {
            num = left + (right - left) / 2; // 2
            res = guess(num); // 0
            if (res > 0) {
                left = num + 1; // 3
            } else {
                right = num - 1; // 3
            }
        }
        return num;
    }
}