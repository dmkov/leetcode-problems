/**

Input: s = "hello"
Output: "holle"

Input: s = "leetcode"
Output: "leotcede"

 Q: If I have odd number of vowels? still replace it

 "teat" - taet
 "aoe" - eoa
 "a" - a
 "trreaa" -
     l r

 "aa"
 "kk"

 Solutions:
 1. Two pointers, moving from left and right to the center
 2. When both pointers find a vowel, swap values
 O(n)
 */
class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (!isVowel(arr[left]) && left < right) {
                left++;
            }
            while (!isVowel(arr[right]) && left < right) {
                right--;
            }
            if (isVowel(arr[left]) && isVowel(arr[right])) {
                swap(arr, left, right);
            }
            left++;
            right--;
        }

        return String.valueOf(arr);
    }

    private boolean isVowel(char ch) {
        Set<Character> vowels = new HashSet(
            Arrays.asList('a', 'i', 'e', 'o', 'u', 'A', 'I', 'E', 'O', 'U'));
        return vowels.contains(ch);
    }

    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}