/**

[0,0,1,5,0,0] 
[0,2]
m - 4
n - 2

 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException();
        }
        while (m > 0 && n > 0) {
            if (nums1[m - 1] <= nums2[n - 1]) {
                nums1[n + m - 1] = nums2[n - 1];
                n--;
            } else {
                nums1[n + m - 1] = nums1[m - 1];
                m--;
            }
        }
        while (m > 0) {
            nums1[n + m - 1] = nums1[m - 1];
            m--;
        }
        while (n > 0) {
            nums1[n + m - 1] = nums2[n - 1];
            n--;
        }

    }
}