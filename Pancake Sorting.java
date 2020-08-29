class Solution {
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> list = new ArrayList<>();
		int end = A.length;
		while (end != 1) {
			int index = find(A, end);
			flip(A, index);
			flip(A, end - 1);
			list.add(index + 1);
			list.add(end);
            end--;
		}
		return list;
	}


	private int find(int[] A, int target) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == target) {
				return i;
			}
		}
		return -1;
	}

	private void flip(int[] A, int end) {
		int start = 0;
		while (start < end) {
			int temp = A[start];
			A[start++] = A[end];
			A[end--] = temp;

		}
	}
}