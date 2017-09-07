class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int count = 0, max = 0;
        for(int i =0; i<s.length(); i++)
        {
            char tempChar = s.charAt(i);
            if(!set.contains(tempChar))
            {
                set.add(tempChar);
                count++;
                if(max <= count)
                    max = count;
            }
            else{
                set.clear();
                set.add(s.charAt(i));
                count=1;
                for(int j =i-1;j>=0;j--)
                {
                    if(s.charAt(j) == s.charAt(i)){
                        break;

                    }
                    else
                    {

                        set.add(s.charAt(j));
                        count++;
                        if(max <= count)
                            max = count;
                    }

                }
            }
        }
        return max;

    }
}