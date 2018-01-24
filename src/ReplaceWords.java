class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        if(sentence == null || sentence.length() == 0) return sentence;
        else {
            Set<String> set = new HashSet<>();
            Boolean replacedSet = false;
            for(int i=0; i<dict.size(); i++) set.add(dict.get(i));
            StringBuilder replacedStr = new StringBuilder("");
            String[] parts = sentence.split(" ");
            for(int i=0; i<parts.length; i++) {
                replacedSet=false;
                for(int j=0; j<parts[i].length(); j++) {
                    if(set.contains(parts[i].substring(0, j+1))) {
                        replacedStr.append(parts[i].substring(0, j+1));
                        replacedSet = true;
                        break;
                    }
                }
                if(replacedSet == false) {
                    replacedStr.append(parts[i]);
                }
                replacedStr.append(" ");
            }
            replacedStr.deleteCharAt(replacedStr.length()-1);
            return replacedStr.toString();
        }
    }
}
