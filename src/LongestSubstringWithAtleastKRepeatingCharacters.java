class Solution {
    private int maxLength=0;
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0 || k > s.length()) return 0;
        else {
            Map<Character, Integer> map = new HashMap<>();
            for(int i=0; i<s.length(); i++) {
                if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                else map.put(s.charAt(i), 1);
            }
            char charDeleted = 'z';
            int count=0, flag=0;
            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                if(entry.getValue() < k) {
                    charDeleted = entry.getKey();
                    count = entry.getValue();
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) return s.length();
            else {
                int i=0, start=0;
                for(; i<s.length() && count > 0; i++) {
                    if(s.charAt(i) == charDeleted) {
                        count--;
                        int temp = longestSubstring(s.substring(start, i), k);
                        if(temp > maxLength) maxLength = temp;
                        start = i+1;
                    }
                }
                if(s.charAt(s.length()-1) != charDeleted) {
                    int temp = longestSubstring(s.substring(start), k);
                    if(temp > maxLength) maxLength = temp;
                }
                return maxLength;
            }
        }
    }
}
