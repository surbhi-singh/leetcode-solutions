class TicTacToe {

    int[] rows;
    int[] cols;
    int[] diagonals;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonals = new int[2];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player == 1) {
            rows[row]++;
            cols[col]++;
            if(row == col) diagonals[0]++;
            if(row+col == n-1) diagonals[1]++;
        }
        else {
            rows[row]--;
            cols[col]--;
            if(row == col) diagonals[0]--;
            if(row+col == n-1) diagonals[1]--;
        }
        for(int i=0; i<n; i++) {
            if(rows[i] == n) return 1;
            else if(rows[i] == -n) return 2;
        }
        for(int i=0; i<n; i++) {
            if(cols[i] == n) return 1;
            else if(cols[i] == -n) return 2;
        }
        for(int i=0; i<2; i++) {
            if(diagonals[i] == n) return 1;
            else if(diagonals[i] == -n) return 2;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
