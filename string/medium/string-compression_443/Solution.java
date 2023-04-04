/**
  "abbbbcddeee" -> ab4cd2e3
                   ab400

    char ch
    in count

    O(n)
 */

class Solution {
    public int compress(char[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException();
        }
        char ch = chars[0];
        int count = 1;
        int w = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != ch) {
                w = write(chars, w, ch, count);
                count = 1;
                ch = chars[i];
            } else {
                count++;
            }
        }
        return write(chars, w, ch, count);
    }

    private int write(char[] chars, int w, char ch, int count) {
        chars[w++] = ch;
        if (count > 1) {
            String c = String.valueOf(count);
            for (int i = 0; i < c.length(); i++) {
                chars[w++] = c.charAt(i);
            }
        }
        return w;
    }
}