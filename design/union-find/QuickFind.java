class QuickFind {

	int[] arr;

	public QuickFind(int n) {
		this.arr = new int[n];
		for (int i = 0; i < n; i++) {
			this.arr[i] = i;
		}
	}

	public boolean connected(int i, int j) {
		if (i < 0 || i > arr.length - 1 || j < 0 || j > arr.length - 1 ) {
			throw new IllegalArgumentException();
		}
		return arr[i] == arr[j];
	}

	public void union (int i, int j) {
		if (i < 0 || i > arr.length - 1 || j < 0 || j > arr.length - 1 ) {
			throw new IllegalArgumentException();
		}

		int newValue = arr[i];
		int toReplace = arr[j];
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] == toReplace) {
				arr[k] = newValue;
			}
		}
	}
	
}