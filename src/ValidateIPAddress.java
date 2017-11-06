import java.util.regex.*;

class Solution {
    public String validIPAddress(String IP) {
        if(IP.length() == 0 || IP == null)
            return "Neither";
        String[] strings = IP.split("\\.");

        if(strings.length == 4) {
            //IPv4

            if(IP.charAt(IP.length()-1) == '.')
                return "Neither";
            String reg = "0(.+)|^$";
            String reg2 = "[0-9]+";
            Pattern p = Pattern.compile(reg);
            for(int i=0; i<strings.length; i++) {
                if(strings[i].length() <= 3 && Pattern.matches(reg2, strings[i])) {
                    int number = Integer.parseInt(strings[i]);
                    if(number >= 0 && number <= 255) {
                        Matcher m = p.matcher(strings[i]);
                        if(m.find()){
                            return "Neither";
                        }
                    }
                    else {
                        return "Neither";
                    }
                }
                else {
                    return "Neither";
                }
            }
            return "IPv4";
        }
        else {
            String[] str = IP.split(":");
            if(str.length == 8) {
                //IPv6

                if(IP.charAt(IP.length()-1) == ':')
                return "Neither";
                String reg = "^[0-9a-fA-F]+$";
                Pattern p = Pattern.compile(reg);
                for(int i=0; i<str.length; i++) {
                    if(str[i].length() <= 4) {
                        Matcher m = p.matcher(str[i]);
                        if(!m.find()) {
                            return "Neither";
                        }
                    }
                    else {
                        return "Neither";
                    }
                }
                return "IPv6";
            }
            else {
                return "Neither";
            }
        }
    }
}
