import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxcount = 0;

        for (int i = 0; i < s.length(); i++) {

            boolean[] seen = new boolean[256]; 

            for (int j = i; j < s.length(); j++) {

                char ch = s.charAt(j);
                if (seen[ch]) {
                    break;
                }

                seen[ch] = true;

                int len = j - i + 1;
                if (len > maxcount) {
                    maxcount = len;
                }
            }
        }
        return maxcount;
    }
}