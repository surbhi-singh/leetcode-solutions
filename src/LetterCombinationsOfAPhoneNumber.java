class Solution {
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        List<String> result = new ArrayList<>();
        if(length == 0) {
            return result;
        }
        else {
            String[][] mapping = new String[][]{{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
            int firstChar = Character.getNumericValue(digits.charAt(0));
            if(firstChar < 2) {
                return result;
            }
            String[] arr = mapping[firstChar - 2];
            for(String s: arr) {
                result.add(s);
            }
            for(int i=1; i<length; i++) {
                if(Character.getNumericValue(digits.charAt(i)) < 2) {
                    return new ArrayList<String>();
                }
                String[] temp = mapping[Character.getNumericValue(digits.charAt(i))-2];
                List<String> res = new ArrayList<>();
                for(int len=0; len<result.size(); len++) {
                    for(int k=0; k<temp.length; k++) {
                        String str = result.get(len)+""+temp[k];
                        res.add(str);
                    }
                }
                result = new ArrayList<>(res);
            }
        }
        return result;
    }
}
