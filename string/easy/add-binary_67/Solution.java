/**

    "1001100"
        "100" 
     1010000

     "11"
     "11"
     110

 */


class Solution {
    public String addBinary(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException();
        }
        int l1 = s1.length(), l2 = s2.length();
        int memo = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 > 0 || l2 > 0) {
            int n1 = 0, n2 = 0;
            if (l1 > 0) { // 1
                n1 = s1.charAt(l1 - 1) - '0';
                l1--;
            }
            if (l2 > 0) { // 0
                n2 = s2.charAt(l2 - 1) - '0';
                l2--;
            }
            int sum = n1 + n2 + memo;
            sb.append(sum % 2);
            memo = sum / 2;
        }
        if (memo != 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}

/**

    "110"
     "10" 
    1000

 0 - 0
 1 - 1
 2 - 0
 3 - 1


 */