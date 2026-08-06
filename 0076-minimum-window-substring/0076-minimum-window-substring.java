class Solution {

    public String minWindow(String s, String t) {

        // If s is smaller than t, answer is impossible
        if (s.length() < t.length())
            return "";

        // Store frequency of characters in t
        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        // Left pointer
        int begin = 0;

        // Right pointer
        int end = 0;

        // Number of matched characters
        int counter = 0;

        // Minimum window length
        int min = Integer.MAX_VALUE;

        // Starting index of minimum window
        int start = 0;

        // Expand the window
        while (end < s.length()) {

            // If current character is needed
            if (map[s.charAt(end)] > 0)
                counter++;

            // Reduce frequency because character is included
            map[s.charAt(end)]--;

            // Move right pointer
            end++;

            // When all characters are matched
            while (counter == t.length()) {

                // Update minimum window
                if (end - begin < min) {
                    min = end - begin;
                    start = begin;
                }

                // Remove left character from window
                map[s.charAt(begin)]++;

                // If removed character was required
                if (map[s.charAt(begin)] > 0)
                    counter--;

                // Move left pointer
                begin++;
            }
        }

        // If no window found
        if (min == Integer.MAX_VALUE)
            return "";

        // Return minimum window substring
        return s.substring(start, start + min);
    }
}