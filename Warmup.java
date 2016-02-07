public class Warmup {

    public static boolean isPalindrome(String str) {
        for (int index = 0 ; index < str.length() / 2 ; index++) {
            if (str.charAt(index) != str.charAt(str.length() - 1 - index)) {
                return false;
            }
        }
        return true;
    }
    
    public static String longestPalindrome(String str) {
        for (int shorten = 0 ; shorten < str.length() ; shorten++) {
            for (int startIndex = 0 ; startIndex <= shorten ; startIndex++) {
                if (isPalindrome(str.substring(startIndex, str.length() - shorten + startIndex))) {
                    return str.substring(startIndex, str.length() - shorten + startIndex);
                }
            }
        }
        
        return "";
    }
    
    public static String longestBreakpoint(String str) {
        // fa aaaabbbbccc
        
        int maxLength = 0;
        String max = "";
        for (int breakpoint = 0 ; breakpoint <= str.length() ; breakpoint++ ) {
            int breakpointLength = 0;
            String breakpointValue = "";
            
            if (breakpoint > 0) {
                // Get the character on the left of the break
                char left = str.charAt(breakpoint - 1);
                // Index of the current left character being checked
                int leftIndex = breakpoint - 1;
                // While the character matches the left character
                while (leftIndex >= 0 && str.charAt(leftIndex) == left) {
                    // Add it to the breakpoint string and reduce the index
                    breakpointValue = left + breakpointValue;
                    leftIndex--;
                    breakpointLength++;
                }
            }
            // Same for the right side
            if (breakpoint < str.length()) {
                char right = str.charAt(breakpoint);
                int rightIndex = breakpoint;
                while (rightIndex < str.length() && str.charAt(rightIndex) == right) {
                    breakpointValue = breakpointValue + right;
                    rightIndex++;
                    breakpointLength++;
                }
            }
            
            if (breakpointLength > maxLength) {
                maxLength = breakpointLength;
                max = breakpointValue;
            }
        }
        return max;
    }
}
