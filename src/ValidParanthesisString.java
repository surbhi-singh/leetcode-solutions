class Solution {
    public boolean checkValidString(String s) {
        if(s.length() == 0 || s.trim().length() == 0 || s == null)
            return true;
        else {
            Stack<List> stack = new Stack<List>();
            Set<List> set = new HashSet<>();

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '*') {
                    List tempList = new ArrayList<>();
                    tempList.add('*');
                    tempList.add(i);
                    set.add(tempList);
                }
                else if(s.charAt(i) == '(') {
                    List tempList = new ArrayList<>();
                    tempList.add('(');
                    tempList.add(i);
                    stack.push(tempList);
                }
                else {
                    if(stack.isEmpty()) {
                        int k;
                        for(k=i-1; k>=0; k--) {
                            if(s.charAt(k) == '*') {
                                List tempList = new ArrayList<>();
                                tempList.add('*');
                                tempList.add(k);
                                if(set.size() == 0 || !set.contains(tempList)) {
                                    return false;
                                }
                                else {
                                    set.remove(tempList);
                                    break;
                                }
                            }
                        }
                        if(k < 0) {
                            return false;
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
                for(k=i+1; k<s.length(); k++) {
                    if(s.charAt(k) == '*') {
                        List tempList = new ArrayList<>();
                        tempList.add('*');
                        tempList.add(k);
                        if(set.size() == 0) {
                            return false;
                        }
                        else if(set.contains(tempList)) {
                            set.remove(tempList);
                            break;
                        }
                    }
                }
                if(k == s.length()) {
                    return false;

                }
            }
            return true;
        }
    }
}
