class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<Integer> curr = new ArrayList<Integer>();
		List<List<Integer>> ans = new ArrayList<>();
		rec(arr, 0, curr, ans);
        return ans;
    }
    
    public void rec(int[] arr, int i, List<Integer> curr, List<List<Integer>> ans) {
		if (i == arr.length) {
			ans.add(new ArrayList<Integer>(curr));
			return;
		}
		curr.add(arr[i]);
		rec(arr, i + 1, curr, ans);
		curr.remove(curr.size() - 1);
		rec(arr, i + 1, curr, ans);
        
	}
}


