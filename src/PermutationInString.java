class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()  > s2.length() || s2 == null || s2.length() == 0) return false;
        else if(s1 == null || s1.length() == 0) return true;
        else {
            HashMap<Character, Integer> map = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for(int i=0; i<s1.length(); i++) {
                if(map.containsKey(s1.charAt(i))) map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
                else map.put(s1.charAt(i), 1);
            }
            for(int i=0; i<s2.length(); i++) {
                if(map2.containsKey(s2.charAt(i))) map2.put(s2.charAt(i), map2.get(s2.charAt(i)) + 1);
                else map2.put(s2.charAt(i), 1);
                if((i+1) >= s1.length()) {
                    if(map2.equals(map)) return true;
                    else if(!map2.isEmpty()) {
                        int count = map2.get(s2.charAt(i-s1.length()+1));
                        if(count == 1) map2.remove(s2.charAt(i-s1.length()+1));
                        else map2.put(s2.charAt(i-s1.length()+1), count-1);
                    }
                }
            }
            return false;
        }
    }
}
