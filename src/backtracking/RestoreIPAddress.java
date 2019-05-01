package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    /*
    Leetcode : 93. Restore IP Addresses

    Thought:
    Each IP4 address has 4 parts and the value ranges from 0 to 255
    Use 4 for loops each going from 1 to 4 (because substring is exclusive)
    Check each set of ip is valid.

    Technique : use substring and ranges

    NOTE: At each for loop do not exceed the boundary
    EX: for(int third = 1; (first + second + third) < len && third < 4; ++third)

    substring boundary:
    String thirdStr = s.substring((first + second), (first + second + third));
    */
    public static List<String> restoreIpAddresses(String s) {
        List<String> result  = new ArrayList<>();


        int len = s.length();
        if(len < 4) return result; // 1111

        // substring is exclusive
        for(int first = 1; first < len && first < 4; first++) {

            String firstStr = s.substring(0, first);
            if(!isValidPart(firstStr)) continue;

            for(int second = 1; (first + second) < len && second < 4; second++) {

                // SEE : substring boundaries
                String secondStr = s.substring(first, (first + second));
                if(!isValidPart(secondStr)) continue;

                // SEE : the boundary check in the for loop
                for(int third = 1; (first + second + third) < len && third < 4; third++) {

                    String thirdStr = s.substring((first + second), (first + second + third));
                    if(!isValidPart(thirdStr)) continue;

                    String fourthStr = s.substring((first + second + third));
                    if(!isValidPart(fourthStr)) continue;

                    result.add(firstStr + "." + secondStr + "." + thirdStr + "." + fourthStr);
                }
            }
        }

        return result;
    }

    /*
    * Each part of the IP address is valid if
    * 1) less than 3 characters long.
    * 2) can be 0 and cannot start with 0 followed by something.
    * 3) is between 0 and 255
    * */
    private static boolean isValidPart(String s) {

        if(s.length() > 3) return false;

        // invalid : 00, 005, 050, 000
        // valid : 0
        if(s.startsWith("0") && s.length() > 1) return false;

        int value = Integer.parseInt(s);
        return (value >= 0 && value <= 255);
    }

    public static void main(String[] args) {

        String s = "25525511135";
        System.out.println("IPs formed from " + s + " are " + restoreIpAddresses(s));

    }
}
