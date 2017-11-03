class Solution {
    int[][] numPaths;
    private int getPaths(int[][] obstacleGrid, int m, int n) {
        if(m < 0 || n < 0)
            return 0;
        else if(m == 0 && n == 0 && obstacleGrid[m][n] != 1) {
            return 1;
        }
        else {
            if(numPaths[m][n] != 0) {
                return numPaths[m][n];
            }
            else if(obstacleGrid[m][n] == 1){
                numPaths[m][n] = 0;
                return numPaths[m][n];
            }
            else {
                numPaths[m][n] = getPaths(obstacleGrid, m-1, n) + getPaths(obstacleGrid, m, n-1);
                return numPaths[m][n];
            }
        }
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        if(obstacleGrid[0][0] == 1)
            return 0;
        else {
            numPaths = new int[obstacleGrid.length][obstacleGrid[0].length];
            numPaths[0][0] = 1;
            return getPaths(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1);
        }

    }
}
