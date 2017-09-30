class Solution {
    public boolean judgeCircle(String moves) {
        int x=0, y=0;
        int len = moves.length();
        for(int i=0; i<len; i++){
            if(moves.charAt(i) == 'U') y++;
            else if(moves.charAt(i) == 'L') x--;
            else if(moves.charAt(i) == 'R') x++;
            else if(moves.charAt(i) == 'D') y--;
        }
        if(x==0 && y==0) return true;
        else return false;
    }
}
