class Solution {
    int[][] numpaths;
    private int getPathsCount(int robotx, int roboty, int m, int n) {
        if(robotx == 0 && roboty == 0)
            return 1;
        else if(robotx <0 || roboty < 0)
            return 0;
        else {
            if(numpaths[robotx][roboty] != 0)
                return numpaths[robotx][roboty];
            else {
                numpaths[robotx][roboty] = getPathsCount(robotx-1, roboty, m, n) + getPathsCount(robotx, roboty-1, m, n);
                return numpaths[robotx][roboty];
            }
        }
    }
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)
            return 0;
        else{
            numpaths = new int[m][n];
            numpaths[0][0] = 1;
            getPathsCount(m-1, n-1, m-1, n-1);
            return numpaths[m-1][n-1];
        }
    }
}
