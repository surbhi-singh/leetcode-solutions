class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res=0;
                if(tokens[i].equals("+")) res = num1 + num2;
                else if(tokens[i].equals("-")) res = num1 - num2;
                else if(tokens[i].equals("*")) res = num1 * num2;
                else if(tokens[i].equals("/")) res = num1 / num2;
                stack.push(res);
            }
            else {
                //System.out.println(tokens[i]);
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
