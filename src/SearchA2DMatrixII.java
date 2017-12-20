class Solution {
    boolean[][] visited;
    private boolean search(int[][] matrix, int i, int j, int target) {
        if(i >= matrix.length || j >= matrix[0].length || matrix[i][j] > target || visited[i][j] == true) {
            return false;
        }
        else {
            visited[i][j] = true;
            if(matrix[i][j] == target) return true;
            else {
                return search(matrix, i+1, j, target) || search(matrix, i, j+1, target);
            }
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        else {
            visited = new boolean[matrix.length][matrix[0].length];
            return search(matrix, 0, 0, target);
        }

    }
}
