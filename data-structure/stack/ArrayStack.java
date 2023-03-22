
class ArrayStack {

	int[] arr;
	int last;

	public ArrayStack(int n) {
		this.arr = new int[n];
		this.last = 0
	}

	public boolean isEmpty() {
		return last == 0;
	}

	public void push(int num) {
		if (last == arr.length) {
			resize(arr.length * 2);
		}
		arr[last++] = num;
	}

	public int peek() {
		if (isEmpty()) {
			throw new IllegalOperationException();
		}
		return arr[last - 1];
	}

	public int pop() {
		if (isEmpty()) {
			throw new IllegalOperationException();
		}
		int val = arr[--last];
		arr[last] = null;

		if (last == arr.length / 4) {
			resize(arr.length / 2);
		}

		return val;
	}

	private void resize(int size) {
		int[] a = new a[size];
		for (int i = 0; i < Math.min(size, arr.length); i++) {
			a[i] = arr[i];
		}
		arr = a;
	}



    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("pop (3) = " + stack.pop());
        System.out.println("peek (2) = " + stack.peek());
        System.out.println("peek (2) = " + stack.peek());
        stack.push(3);
        System.out.println("pop (3) = " + stack.pop());
        System.out.println("pop (2) = " + stack.pop());
        stack.push(3);
        System.out.println("size (2) = " + stack.size());
        System.out.println("isEmpty (false) = " + stack.isEmpty());
        System.out.println("pop (3) = " + stack.pop());
        System.out.println("pop (1) = " + stack.pop());
        System.out.println("size (0) = " + stack.size());
        System.out.println("isEmpty (true) = " + stack.isEmpty());
    }

}