/**
Input: s = "ab#c", t = "ad#c"
Output: true

Input: s = "ab##", t = "c#d#"
Output: true

Input: s = "a#c", t = "b"
Output: false

Q: What is the output format? boolean
Q: any other special characters? no
Q: it can be multiple # characters in the string? yes

"#####" ""
-> true

Solutions:
1. Stack: Iterate both strings and add characters to the stack. 
With every "#"" pop the last element from the stack. At the end compare stacks.
O(n) + O(n)
2. Java StringBuilder for more clean code

*/


class Solution {
    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException();
        }

        Deque<Character> stack1 = getStackFromString(s);
        Deque<Character> stack2 = getStackFromString(t);

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }

    private Deque<Character> getStackFromString(String s) {
        Deque<Character> stack = new ArrayDeque();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack;
    }
}