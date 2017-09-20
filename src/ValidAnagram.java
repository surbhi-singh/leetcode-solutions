class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<String, Integer> mapS = new HashMap<>();
        HashMap<String, Integer> mapT = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!mapS.containsKey(Character.toString(s.charAt(i))))
                mapS.put(Character.toString(s.charAt(i)), 1);
            else{
                int temp = mapS.get(Character.toString(s.charAt(i)));
                mapS.put(Character.toString(s.charAt(i)), temp+1);
            }

            if(!mapT.containsKey(Character.toString(t.charAt(i))))
                mapT.put(Character.toString(t.charAt(i)), 1);
            else{
                int temp = mapT.get(Character.toString(t.charAt(i)));
                mapT.put(Character.toString(t.charAt(i)), temp+1);
            }

        }
        if(mapS.equals(mapT))
            return true;
        else
            return false;
    }
}
