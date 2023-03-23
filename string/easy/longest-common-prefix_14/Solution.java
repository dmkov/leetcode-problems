/**

Input: strs = ["abc","abcd","ab"]
Output: "ab"

Input: strs = ["def","abc","abd"]
Output: ""

Q: We have array of strings?
Q: Strings can be any size, even empty?
Q: lowercase / capitals?


Solutions:
1. Scanning: Iterate first string and check char in all words - O(n*m) O(n)
2. Divide&Conquer: Recursively find common prefix in smaller groups - O(n*m) O(mlogn)


 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            throw new IllegalArgumentException();
        }    
        if (strs[0] == null || strs[0].length() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || strs[j].charAt(i) != ch) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}

// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs == null) {
//             throw new IllegalArgumentException();
//         }    
//         return longestCommonPrefix(strs, 0, strs.length - 1);
//     }

//     private String longestCommonPrefix(String[] strs, int start, int end) {
//         if (start == end) {
//             return strs[start];
//         }

//         int mid = start + (end - start) / 2;
//         return commonPrefixFromStrings(
//             longestCommonPrefix(strs, start, mid),
//             longestCommonPrefix(strs, mid + 1, end)
//         );
//     }

//     private String commonPrefixFromStrings(String first, String second) {
//         StringBuilder sb = new StringBuilder();
//         int i = 0;
//         while (i < first.length() && i < second.length()
//             && first.charAt(i) == second.charAt(i)) {
//             sb.append(first.charAt(i));
//             i++;
//         }
//         return sb.toString();
//     }

// }