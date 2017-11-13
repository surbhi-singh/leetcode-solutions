class Solution {
    private Boolean findWord(char[][] board, String word, int posx, int posy, Boolean[][] visited) {
        if(word.length() == 0 || word == null)
            return true;
        else if(posx >= board.length || posy >=board[0].length || posx < 0 || posy < 0) {
            return false;
        }
        else if(visited[posx][posy] == false) {

            if(board[posx][posy] == word.charAt(0)) {
                visited[posx][posy] = true;
                if((findWord(board, word.substring(1), posx+1, posy, visited) || findWord(board, word.substring(1), posx, posy+1, visited)                        || findWord(board, word.substring(1), posx-1, posy, visited) || findWord(board, word.substring(1), posx, posy-1,                              visited)) == false) {
                    visited[posx][posy] = false;
                    return false;
                }
                else
                    return true;
            }
            else {
                return false;
            }
        }
        else
            return false;
        }

    public boolean exist(char[][] board, String word) {
        if(word == null || word.trim().length() == 0)
            return false;
        else {
            Boolean[][] visited = new Boolean[board.length][board[0].length];
            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[0].length; j++) {
                    visited[i][j] = false;
                }
            }
            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[0].length; j++) {
                    if(board[i][j] == word.charAt(0)) {
                        if(findWord(board, word, i, j, visited) == true)
                            return true;
                    }
                }
            }
            return false;
        }

    }
}
