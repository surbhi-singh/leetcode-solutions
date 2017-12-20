class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return result;
        else {
            Map<String, List<String>> map = new HashMap<>();
            for(String s: strs) {
                char[] tempCharArray = s.toCharArray();
                Arrays.sort(tempCharArray);
                String str = new String(tempCharArray);
                if(map.containsKey(str)) {
                    List<String> tempList = map.get(str);
                    tempList.add(s);
                    map.put(str, tempList);
                }
                else {
                    List<String> tempList = new ArrayList<>();
                    tempList.add(s);
                    map.put(str, tempList);
                }
            }
            return new ArrayList<List<String>>(map.values());
        }
    }
}
