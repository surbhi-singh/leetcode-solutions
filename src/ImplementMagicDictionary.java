class MagicDictionary {

    Set<String> dicts;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        dicts = new HashSet<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(int i=0; i<dict.length; i++) dicts.add(dict[i]);
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(int i=0; i<word.length(); i++) {
            for(int j=0; j<26; j++) {
                char tempchar = (char)('a' + j);
                if(tempchar != word.charAt(i)) {
                    String temp = word.substring(0, i) + Character.toString(tempchar) + word.substring(i+1);
                    if(dicts.contains(temp)) return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
