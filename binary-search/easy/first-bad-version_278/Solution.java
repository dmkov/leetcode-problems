/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/**
  We can reprensent problem with the array where the first part is 0 
  and the rest is 1s:

  [0,0,0,1]

  And we need to find the index of first 1.

  Q: [y, y, y, f, f, f, y, y ,f] - not possible
  Q: n from 1 to Integer.MAX_VALUE

  Solutions:
    1. Naive: iterate from 1 to n and check the version
    O(n)

    2. Binary search: 
    O(logn)
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }

        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
      f f f
   [1,2,3,4]
    l r  
      |  


 */