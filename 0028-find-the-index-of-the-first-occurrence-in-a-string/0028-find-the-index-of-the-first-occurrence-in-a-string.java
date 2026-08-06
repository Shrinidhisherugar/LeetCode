class Solution {
    public int strStr(String haystack, String needle) {

        // Length of haystack and needle
        int hLen = haystack.length();
        int nLen = needle.length();

        // Check every possible starting position
        for (int i = 0; i <= hLen - nLen; i++) {

            // Compare substring with needle
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i; // Match found
            }
        }

        // No match found
        return -1;
    }
}