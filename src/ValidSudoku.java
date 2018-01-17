class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        else {
            Set<Character> set = new HashSet<>();
            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[0].length; j++) {
                    if(board[i][j] != '.') {
                        if(set.contains(board[i][j])) return false;
                        else set.add(board[i][j]);
                    }
                }
                set.clear();
            }
            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[0].length; j++) {
                    if(board[j][i] != '.') {
                        if(set.contains(board[j][i])) return false;
                        else set.add(board[j][i]);
                    }
                }
                set.clear();
            }
            int i=0, j=0, count=0;
            while(i<board.length) {
                for(int row=i; row<i+3; row++) {
                    for(int col=j; col<j+3; col++) {
                        if(board[row][col] != '.') {
                            if(set.contains(board[row][col])) return false;
                            else set.add(board[row][col]);
                        }
                    }
                }
                count++;
                set.clear();
                if(count%3 != 0) j += 3;
                else {
                    i += 3;
                    j = 0;
                }
            }
            return true;
        }
    }
}
