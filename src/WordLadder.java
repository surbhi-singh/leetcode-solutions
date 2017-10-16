class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> bank = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for(int i=0; i<wordList.size(); i++) {
            bank.add(wordList.get(i));
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord+ " "+ 1);
        visited.add(beginWord);
        int count=0;
        while(!queue.isEmpty()) {
            String[] str = queue.poll().split(" ");
            if(str[0].equals(endWord)) {
                count = Integer.parseInt(str[1]);
                break;
            }
            for(int i=0; i<str[0].length(); i++) {
                for(char c='a'; c<='z'; c++) {
                    if(c != str[0].charAt(i)) {
                        String successor = str[0].substring(0, i)+c+str[0].substring(i+1);
                        if(!visited.contains(successor) && bank.contains(successor)) {
                            int temp = Integer.parseInt(str[1])+1;
                            queue.offer(successor+" "+temp);
                            visited.add(successor);
                        }
                    }
                }
            }
        }
        return count;
    }
}
