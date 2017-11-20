class Solution {
    List<String> result;
    private void check(int n, int countOpenBr, int numberOfChars, String s) {
        StringBuilder str = new StringBuilder(s);
        if(numberOfChars == 2*n) {
            result.add(s);
        }
        else if(countOpenBr == 0) {
            str.append("(");
            check(n, ++countOpenBr, numberOfChars+1, str.toString());
        }
        else if(countOpenBr == n) {
            str.append(")");
            check(n, countOpenBr, numberOfChars+1, str.toString());
        }
        else {
            str.append("(");
            check(n, countOpenBr+1, numberOfChars+1, str.toString());
            str.deleteCharAt(str.length()-1);
            if((numberOfChars/2) != countOpenBr) {
                str.append(")");
                check(n, countOpenBr, numberOfChars+1, str.toString());
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        check(n, 0, 0, new String());
        return result;
    }
}
