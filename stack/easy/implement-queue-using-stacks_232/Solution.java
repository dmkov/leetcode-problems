/**
 push(1), push(2),
 1 , 2
 ^

 peek() -> 1
 1 , 2
 ^

 pop() -> 1
 2
 ^

1 , 2
    ^

Solutions:
1. With every pop() or peek() - reverse 1 stack into 2 and then reverse back
O(n)
Push - just add to the 1st stack
O(1)

2. Perform pop()/peek() and push() operations to different stacks.
With every push - add to the 1st, with every pop() - take from the 2nd.
When 2nd is empty - reverse 1st to it.
O(1) amortized

*/

class MyQueue {

    Deque<Integer> first; // 1, 2
    Deque<Integer> second; //

    public MyQueue() {
        first = new ArrayDeque();
        second = new ArrayDeque();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        if (empty()) {
            throw new IllegalArgumentException();
        }
        if (second.isEmpty()) {
            reverse();
        }
        return second.pop();
    }
    
    public int peek() {
        if (empty()) {
            throw new IllegalArgumentException();
        }
        if (second.isEmpty()) {
            reverse();
        }
        return second.peek();
    }

    private void reverse() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
    }
    
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */