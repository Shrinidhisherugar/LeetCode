class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();   // Length of string

        // Try every possible substring length
        for (int i = n / 2; i >= 1; i--) {

            // Check if string can be divided equally
            if (n % i == 0) {

                // Take first substring
                String sub = s.substring(0, i);

                // Store repeated substring
                StringBuilder sb = new StringBuilder();

                // Repeat substring
                for (int j = 0; j < n / i; j++) {
                    sb.append(sub);
                }

                // If repeated string equals original
                if (sb.toString().equals(s))
                    return true;
            }
        }

        // No repeated pattern found
        return false;
    }
}