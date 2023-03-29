/**
    Q: What is the palindrome?
    Q: Do we consider capital letter to be equal to lower case?
    Q: and we can ignore all spaces and special characters?
    Q: Empty string?

    "A b ''a" -> true
    "q,,e,r" -> false
    "q" -> true
    "q,q" -> true
    "''" -> true?

    Solutions:
    Using two pointers from left and right sides, compare chars. If they are equal
     -> reduce the window, if not - return false.

    
    "A ''a"
     |   |
 */

class Solution {
    public boolean isPalindrome(String s) {
        boolean res = true;
        if (s == null || s.length() == 0) {
            return res;
        }
        // s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!isAlphanumeric(s.charAt(left))) {
                left++;
            } else if (!isAlphanumeric(s.charAt(right))) {
                right--;
            } else if (!isSame(s.charAt(left), s.charAt(right))) {
                res = false;
                break;
            } else {
                left++;
                right--;
            }
        }
        return res;
    }

    private boolean isAlphanumeric(char ch) {
        return isLetter(ch)
            || (ch >= '0' && ch <= '9');
    }

    private boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z')
            || (ch >= 'A' && ch <= 'Z');
    }

    private boolean isSame(char ch1, char ch2) {
        int d = 'a' - 'Z' + 25;
        return (ch1 == ch2)
            || (isLetter(ch1) && isLetter(ch2)) && (ch1 - d == ch2 || ch2 - d == ch1);
    }

}