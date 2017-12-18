class Solution {
    public boolean checkValidString(String s) {
        if(s.length() == 0 || s.trim().length() == 0 || s == null)
            return true;
        else {
            Stack<List> stack = new Stack<List>();
            TreeMap<Integer, Character> map = new TreeMap<>();

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '*') {
                    map.put(i, '*');
                }
                else if(s.charAt(i) == '(') {
                    List tempList = new ArrayList<>();
                    tempList.add('(');
                    tempList.add(i);
                    stack.push(tempList);
                }
                else {
                    if(stack.isEmpty()) {
                        if(map.isEmpty()) {
                            return false;
                        }
                        else {
                            map.pollLastEntry();
                        }
                    }
                    else {
                        stack.pop();
                    }
                }
            }
            while(!stack.isEmpty()) {
                int k;
                List poppedItem = stack.pop();
                int i=(int)poppedItem.get(1);
                if(map.isEmpty()) {
                    return false;
                }
                else {
                    Map.Entry<Integer, Character> entry = map.pollLastEntry();
                    if(entry.getKey() < i) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
