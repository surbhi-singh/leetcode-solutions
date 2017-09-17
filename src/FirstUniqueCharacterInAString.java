class Solution {
    public int firstUniqChar(String s) {
        // if(s.length() == 0)
        //     return 0;
        int index=-1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            }
            else{
                map.remove(s.charAt(i));
                map.put(s.charAt(i), -1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() != -1){
                index = entry.getValue();
                break;
            }
        }
        return index;
    }
}
