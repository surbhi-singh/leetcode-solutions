class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length()>s.length())
            return list;
        HashMap<String, Integer> mapS = new HashMap<>();
        HashMap<String, Integer> mapP = new HashMap<>();
        for(int i=0; i<p.length(); i++){
            if(!mapP.containsKey(Character.toString(p.charAt(i))))
                mapP.put(Character.toString(p.charAt(i)), 1);
            else{
                mapP.put(Character.toString(p.charAt(i)), mapP.get(Character.toString(p.charAt(i)))+1);
            }
        }
        for(int i=0, count=0; i<s.length(); i++){
            while(count < p.length()){
                if(!mapS.containsKey(Character.toString(s.charAt(i))))
                mapS.put(Character.toString(s.charAt(i)), 1);
                else{
                mapS.put(Character.toString(s.charAt(i)), mapS.get(Character.toString(s.charAt(i)))+1);
                }
                count++;
                i++;
            }
            if(mapP.equals(mapS)){
                list.add(i-count);
            }
            int temp = mapS.get(Character.toString(s.charAt(i-count)));
            if(temp-1 == 0)
                mapS.remove(Character.toString(s.charAt(i-count)));
            else
                mapS.put(Character.toString(s.charAt(i-count)), mapS.get(Character.toString(s.charAt(i-count)))-1);
            count--;
            i--;
        }
        return list;
    }
}
