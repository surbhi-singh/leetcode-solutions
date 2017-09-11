class Solution {
    public String countAndSay(int n) {
        String str = new String();
        StringBuilder newStr = new StringBuilder("");
        str = "1";
        HashMap<Character, Integer> map = new HashMap();
        int j=0;
        for(int i=1; i<n; i++){
            for(j=0; j<str.length(); j++){
                if(map.isEmpty()){
                    map.put(str.charAt(j), 1);
                }
                else if(map.containsKey(str.charAt(j))){
                    map.put(str.charAt(j), map.get(str.charAt(j))+1);
                }
                else{
                    newStr.append(map.get(str.charAt(j-1)).toString());
                    newStr.append(str.charAt(j-1));
                    map.clear();
                    map.put(str.charAt(j), 1);
                }

            }
            if(!map.isEmpty()){
                newStr.append(map.get(str.charAt(j-1)).toString());
                newStr.append(str.charAt(j-1));
                map.clear();
            }
            str = newStr.toString();
            newStr.setLength(0);
        }
        return str;
    }
}