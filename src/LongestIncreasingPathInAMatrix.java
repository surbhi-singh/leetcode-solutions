class Solution {
    private int max;
    private int[][] maxPathSum;

    private int findPath(int[][] matrix, int i, int j) {
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length) return 0;
        else if(maxPathSum[i][j] != -1) {
            if(maxPathSum[i][j] > max) max = maxPathSum[i][j];
            return maxPathSum[i][j];
        }
        else {
            int top=0, left=0, right=0, down=0;
            if(i-1 >= 0 && matrix[i][j] > matrix[i-1][j]) top = findPath(matrix, i-1, j);
            if(i+1 < matrix.length && matrix[i][j] > matrix[i+1][j]) down = findPath(matrix, i+1, j);
            if(j-1 >= 0 && matrix[i][j] > matrix[i][j-1]) left = findPath(matrix, i, j-1);
            if(j+1 < matrix[0].length && matrix[i][j] > matrix[i][j+1]) right = findPath(matrix, i, j+1);
            maxPathSum[i][j] = 1 + Math.max(Math.max(Math.max(top, down), right), left);
            if(maxPathSum[i][j] > max) max = maxPathSum[i][j];
            return maxPathSum[i][j];
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        else {
            maxPathSum = new int[matrix.length][matrix[0].length];
            for(int i=0; i<matrix.length; i++) {
                for(int j=0; j<matrix[0].length; j++) {
                    maxPathSum[i][j] = -1;
                }
            }
            max = Integer.MIN_VALUE;
            findPath(matrix, 0, 0);
            for(int i=0; i<matrix.length; i++) {
                for(int j=0; j<matrix[0].length; j++) {
                    if(maxPathSum[i][j] == -1) findPath(matrix, i, j);
                }
            }
            return max;
        }
    }
}
