import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) return res;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Count frequency of characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Initialize the first window
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // Compare the first window
        if (Arrays.equals(pCount, sCount)) {
            res.add(0);
        }

        // Slide the window over s
        for (int i = pLen; i < sLen; i++) {
            sCount[s.charAt(i) - 'a']++; // Add the new character to the window
            sCount[s.charAt(i - pLen) - 'a']--; // Remove the character that is sliding out

            // Compare current window with p
            if (Arrays.equals(pCount, sCount)) {
                res.add(i - pLen + 1);
            }
        }

        return res;
    }

  
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List result = findAnagrams(s, p);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
  
}

