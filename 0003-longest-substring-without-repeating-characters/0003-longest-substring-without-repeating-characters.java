class Solution {
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;

        // Generate all substrings
        for (int i = 0; i < s.length(); i++) {

            String temp = "";

            for (int j = i; j < s.length(); j++) {

                temp += s.charAt(j);

                if (isUnique(temp)) {
                    maxLength = Math.max(maxLength, temp.length());
                } else {
                    break; // stop if duplicate found
                }
            }
        }

        return maxLength;
    }

    // Function to check uniqueness
    public boolean isUnique(String str) {

        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (freq[ch] == 1) {
                return false;
            }

            freq[ch]++;
        }

        return true;
    }
}