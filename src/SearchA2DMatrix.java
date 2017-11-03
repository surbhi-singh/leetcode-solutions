class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0) {
            return false;
        }
        else {
            int targetRow=-1;
            for(int row=0, col=matrix[0].length; row<matrix.length; row++) {
                if(target <= matrix[row][col-1]) {
                    targetRow = row;
                    break;
                }
            }
            if(targetRow == -1)
                return false;
            for(int col=0; col<matrix[0].length; col++) {
                if(matrix[targetRow][col] == target) {
                    return true;
                }
            }
            return false;
        }
    }
}
