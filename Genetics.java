import java.util.HashMap;

public class Genetics {

    public static void main(String[] args) {
        for (int x = 1000 ; x <= 5000 ; x += 1000) {
            String dna = getDNA(x);
            long t1 = System.currentTimeMillis();
            System.out.println(badLongestPalindrome(dna));
            long t2 = System.currentTimeMillis();
            System.out.println(longestPalindrome(dna));
            long t3 = System.currentTimeMillis();

            System.out.println("For " + x + ", " + (t2 - t1) + " ms with O(n^2)");
            System.out.println("For " + x + ", " + (t3 - t2) + " ms with O(n)");
        }
    }

    // Most common substring of a given length
    public static String mostCommonSubstring(String str, int minLength) {
        return "";
    }

    // Most common substring of a given length
    public static String longestPalindromeContaining(String str, String sub) {
        return "";
    }

    public static String mostCommonTriplet(String str) {
        HashMap <String, Integer> frequency = new HashMap <String, Integer> ();

        // Go to each triplet in the DNA string
        for (int i = 0 ; i < str.length() ; i += 3) {
            String triplet = str.substring(i, i + 3);

            // Two cases: it's in the frequency table, or it's not
            if (frequency.containsKey(triplet)) {
                int f = frequency.get(triplet);
                frequency.put(triplet, f + 1);
            }
            else {
                frequency.put(triplet, 1);
            }
        }

        String mostCommon = "";
        int mostCommonCount = 0;

        // Go to every key in the frequency table
        for (String triplet : frequency.keySet()) {
            if (frequency.get(triplet) > mostCommonCount) {
                mostCommonCount = frequency.get(triplet);
                mostCommon = triplet;
            }
        }

        return mostCommon;
    }

    public static String longestPalindrome(String str) {
        //  index  0 1 2 3 4 5 6
        //  str    r a c e c a r
        //  middle 0123456789...

        String longest = "";

        for (int middle = 0 ; middle < 2 * str.length() ; middle++ ) {
            String palindrome = "";
            // For even numbers
            if (middle % 2 == 0) {
                palindrome = palindrome + str.charAt(middle / 2);
                int leftIndex = middle / 2 - 1;
                int rightIndex = middle / 2 + 1;
                while (leftIndex >= 0 && rightIndex < str.length() &&
                        str.charAt(leftIndex) == str.charAt(rightIndex)) {
                    palindrome = str.charAt(leftIndex) + palindrome + str.charAt(rightIndex);
                    leftIndex--;
                    rightIndex++;
                }
            }
            // For odd numbers
            else {
                int leftIndex = middle / 2;
                int rightIndex = middle / 2 + 1;
                while (leftIndex >= 0 && rightIndex < str.length() &&
                        str.charAt(leftIndex) == str.charAt(rightIndex)) {
                    palindrome = str.charAt(leftIndex) + palindrome + str.charAt(rightIndex);
                    leftIndex--;
                    rightIndex++;
                }
            }

            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }

        return longest;
    }

    public static boolean isPalindrome(String str) {
        for (int index = 0 ; index < str.length() / 2 ; index++) {
            if (str.charAt(index) != str.charAt(str.length() - 1 - index)) {
                return false;
            }
        }
        return true;
    }

    public static String badLongestPalindrome(String str) {
        for (int shorten = 0 ; shorten < str.length() ; shorten++) {
            for (int startIndex = 0 ; startIndex <= shorten ; startIndex++) {
                if (isPalindrome(str.substring(startIndex, str.length() - shorten + startIndex))) {
                    return str.substring(startIndex, str.length() - shorten + startIndex);
                }
            }
        }

        return "";
    }

    public static String getDNA(int length) {
        StringBuilder dna = new StringBuilder();

        for (int i = 0 ; i < length ; i++) {
            double rand = Math.random();

            if (rand < 0.25) {
                dna.append("A");
            }
            else if (rand < 0.5) {
                dna.append("G");
            }
            else if (rand < 0.75) {
                dna.append("C");
            }
            else {
                dna.append("T");
            }
        }

        return dna.toString();
    }
}
