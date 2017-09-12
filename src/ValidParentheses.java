class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        char ch;
        Stack<Character> stack = new Stack();
        if(len == 0)
            return true;
        for(int i=0; i<len; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else if(stack.isEmpty()){
                return false;
            }
            else{
                ch = stack.pop();
                if((s.charAt(i) == ')' && ch != '(') || (s.charAt(i) == '}' && ch != '{') || (s.charAt(i) == ']' && ch != '[')){
                    return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}