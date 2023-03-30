/**

"ababccaabc" "abc" -> 2
"aaac"
"aac" -> 1

Q: What type of characters do we have in strings?

Solutions:
1. Two pointers. Iterate the given string until find match with the first character
    After that do inner check for the all remaining characters. If the are different - 
    return to the initial loop
    O(n*m) 

2. Rabin-Karp algorithm. Compute hash of the second string based on the power of 26.
    Compute rolling hash for the main string and with every match, validate substring with
    the second string char by char.

 */
class Solution {
    public int strStr(String s1, String s2) {
        // Rabin-Karp
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException();
        }
        if (s1.length() < s2.length()) {
            return -1;
        }

        int hash1 = 0, hash2 = 0;
        int l = s2.length();
        int MOD = 9999991;
        int p = 0;
        long[] pow = new long[l];
        pow[0] = 1;
        for (int i = 1; i < l; i++) {
            pow[i] = pow[i-1] * 5 % MOD;
        }

        for (int i = l - 1; i >= 0; i--) {
            hash1 += (s1.charAt(i) - 'a') * pow[p] % MOD;
            hash2 += (s2.charAt(i) - 'a') * pow[p] % MOD;
            p++;
        }
        if (hash1 == hash2 && equals(s1.substring(0, l), s2)) {
            return 0;
        }

        p--;
        for (int i = l; i < s1.length(); i++) {
            char remove = s1.charAt(i - l);
            char add = s1.charAt(i);
            hash1 -= (remove - 'a') * pow[p] % MOD;
            hash1 *= 5 % MOD;
            hash1 += (add - 'a')  % MOD;
            if (hash1 == hash2 && equals(s1.substring(i - l + 1, i + 1), s2)) {
                return i - l + 1;
            }
        }
        return -1;
    }

    // public int strStr(String s1, String s2) {
    //     // Naive
    //     if (s1 == null || s2 == null) {
    //         throw new IllegalArgumentException();
    //     }    
    //     for (int i = 0; i <= s1.length() - s2.length(); i++) {
    //         if (s1.charAt(i) == s2.charAt(0)
    //             && equals(s1.substring(i, i + s2.length()), s2)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    private boolean equals(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}