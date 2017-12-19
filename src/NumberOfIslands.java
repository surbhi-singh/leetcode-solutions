class Solution {
    private int[][] checkIsland;
    private boolean isIsland(char[][] grid, int i, int j) {
        if(grid[i][j] == '0') {
            return true;
        }
        boolean left=false, top=false, right=false, down=false;
        checkIsland[i][j] = 1;
        try {
            if(grid[i-1][j] == '0') {
                top = true;
            }
            else if(checkIsland[i-1][j] == 0) {
                top = isIsland(grid, i-1, j);
            }
            else {
                top = true;
            }
        }
        catch(Exception e) {
            top = true;
        }
        try {
            if(grid[i+1][j] == '0') {
                down = true;
            }
            else if(checkIsland[i+1][j] == 0) {
                down = isIsland(grid, i+1, j);
            }
            else {
                down = true;
            }
        }
        catch(Exception e) {
            down = true;
        }
        try {
            if(grid[i][j-1] == '0') {
                left = true;
            }
            else if(checkIsland[i][j-1] == 0) {
                left = isIsland(grid, i, j-1);
            }
            else {
                left = true;
            }
        }
        catch(Exception e) {
            left = true;
        }
        try {
            if(grid[i][j+1] == '0') {
                right = true;
            }
            else if(checkIsland[i][j+1] == 0){
                right = isIsland(grid, i, j+1);
            }
            else {
                right = true;
            }
        }
        catch(Exception e) {
            right = true;
        }
        return left && top && right && down;
    }
    public int numIslands(char[][] grid) {
        int count=0;
        if(grid == null || grid.length == 0) {
            return count;
        }
        checkIsland = new int[grid.length][grid[0].length];
        for(int i=0; i<checkIsland.length; i++) {
            for(int j=0; j<checkIsland[0].length; j++) {
                if(grid[i][j] == '1' && checkIsland[i][j] == 0) {
                    if(isIsland(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
