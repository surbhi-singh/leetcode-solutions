class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>();
        HashSet<Character> keys = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        keys.add('A');
        keys.add('C');
        keys.add('T');
        keys.add('G');
        for(int i=0; i<bank.length; i++) {
            set.add(bank[i]);
        }
        if(!set.contains(end) || start.length() != 8 || end.length() != 8) return -1;
        for(int i=0; i<start.length(); i++) {
            if(!keys.contains(start.charAt(i)) || !keys.contains(end.charAt(i)))
                return -1;
        }
        int count=0, flag=0;
        queue.offer(start+" "+0);
        char[] key = new char[] {'A', 'C', 'T', 'G'};
        while(!queue.isEmpty()) {
            String[] str = queue.poll().split(" ");
            if(str[0].equals(end)) {
                flag = 1;
                count = Integer.parseInt(str[1]);
                break;
            }
            for(int i=0, f=0; i<str[0].length(); i++) {
                for(int j=0; j<key.length; j++) {
                    if(key[j] != str[0].charAt(i)) {
                        String successor = str[0].substring(0, i)+key[j]+str[0].substring(i+1);
                        if(set.contains(successor)) {
                            if(f==0) {
                                count = Integer.parseInt(str[1])+1;
                                f=1;
                            }
                            queue.offer(successor+" "+count);
                        }
                    }
                }
            }
        }
        if(flag != 1)
            return -1;
        else
            return count;

    }
}
