class Trie {

    Map<Character, Map> map;
    /** Initialize your data structure here. */
    public Trie() {
        map = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Map<Character, Map> tempmap = map;
        Map<Character, Map> temp;
        if(word.length() == 0) {
            char ch = '\0';
            map.put(ch, null);
        }
        for(int i=0; i<word.length(); i++) {
            if(tempmap.containsKey(word.charAt(i))) {
                temp = tempmap.get(word.charAt(i));
                if(temp != null) tempmap = temp;
                if(i+1 == word.length() && temp != null) {
                    tempmap.put(null, null);
                    break;
                }
            }
            else {
                tempmap.put(word.charAt(i), null);
                temp = null;
            }
            while(temp == null && ++i < word.length()) {
                Map<Character, Map> newmap = new HashMap<>();
                newmap.put(word.charAt(i), null);
                tempmap.put(word.charAt(i-1), newmap);
                tempmap = newmap;
            }
            if(i == word.length()) {
                Map<Character, HashMap> newm = new HashMap<>();
                newm.put(null, null);
                tempmap.put(word.charAt(i-1), newm);
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(map.isEmpty()) {
            return false;
        }
        if(word.length() == 0) {
            if(map.containsKey('\0')) return true;
            else return false;
        }
        else {
            Map<Character, Map> temp = map;
            for(int i=0; i<word.length(); i++) {
                if(temp.containsKey(word.charAt(i))) {
                    temp = temp.get(word.charAt(i));
                }
                else return false;
            }
            if(temp.containsKey(null)) return true;
            else return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(map.isEmpty()) {
            return false;
        }
        else {
            Map<Character, Map> temp = map;
            for(int i=0; i<prefix.length(); i++) {
                if(temp.containsKey(prefix.charAt(i))) {
                    temp = temp.get(prefix.charAt(i));
                }
                else return false;
            }
            return true;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
