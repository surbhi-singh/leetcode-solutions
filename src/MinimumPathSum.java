class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid == null || grid[0].length == 0)
            return 0;
        else {
            int[] dp = new int[grid[0].length];
            dp[0] = grid[0][0];
            for(int i=1; i<grid[0].length; i++) {
                dp[i] = grid[0][i] + dp[i-1];
            }
            for(int row=1; row<grid.length; row++) {
                dp[0] = dp[0] + grid[row][0];
                for(int col=1; col<grid[0].length; col++) {
                    dp[col] = Math.min((grid[row][col]+dp[col-1]), (grid[row][col]+dp[col]));
                }
            }
            return dp[grid[0].length-1];
        }

    }
}
