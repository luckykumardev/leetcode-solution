class Solution {
    public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
	 int dp[][] = new int[matrix.length][matrix[0].length];
		
		int h = matrix.length;
		int l = matrix[0].length;
		int max = 0;

		int curMax = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < l; j++) {
				curMax = findSquare(matrix, i, j, dp);
				if (max < curMax) {
					max = curMax;
				}
			}
		}
		return max * max;
	}

	private int findSquare(char[][] matrix, int i, int j, int dp[][]) {
		if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') {
			return 0;
		}
        
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		int sum = 1 + Math.min(findSquare(matrix, i + 1, j + 1, dp), Math.min(findSquare(matrix, i + 1, j, dp), findSquare(matrix, i, j + 1, dp)));
		return dp[i][j] = sum;
	}
}