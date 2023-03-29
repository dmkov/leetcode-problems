/**

    "{[{}]}" -> true
    "[{]}" -> false
    "{]}" -> false

    Q: What type of parentheses are allowed? 
        {} [] ()
    Q: Are there any other characters allowed?
        no
    
    So technically, every time when we have a closed parentheses, we should have 
    paired open bracket of the same type.

    Solutions:
    Stack: for every open parentheses, add it to the stack, and for every closed - pop
        element from the stack and check if they are of the same type.
        O(n) + O()n

    [[{}()]]

 */

class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }    
        Deque<Character> stack = new ArrayDeque();
        for (char ch : s.toCharArray()) {
            if (isOpenParenteses(ch)) {
                stack.push(ch);
            } else if (stack.size() == 0 || !isMatchedParenteses(stack.pop(), ch)) {
                return false;
            }
        }
        return stack.size() == 0;
    }

    private boolean isOpenParenteses(char ch) {
        return ch == '{' || ch == '[' || ch == '(';
    }

    private boolean isMatchedParenteses(char ch1, char ch2) {
        return (ch1 == '{' && ch2 == '}') 
            || (ch1 == '[' && ch2 == ']') 
            || (ch1 == '(' && ch2 == ')');
    }
}