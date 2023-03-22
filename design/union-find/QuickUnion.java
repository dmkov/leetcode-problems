class QuickFind {

	int[] arr;

	public QuickFind(int n) {
		this.arr = new int[n];
		for (int i = 0; i < n; i++) {
			this.arr[i] = i;
		}
	}

	public int root(int i) {
		while (i != arr[i]) {
			i = arr[i];
		}
		return i;
	}

	public boolean connected(int i, int j) {
		if (i < 0 || i > arr.length - 1 || j < 0 || j > arr.length - 1 ) {
			throw new IllegalArgumentException();
		}
		return root(i) == root(j);
	}

	public void union (int i, int j) {
		if (i < 0 || i > arr.length - 1 || j < 0 || j > arr.length - 1 ) {
			throw new IllegalArgumentException();
		}

		p = root(i);
		q = root(j);
		arr[p] = q;
	}
	
}